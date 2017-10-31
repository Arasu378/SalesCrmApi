package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.PersonModel;
import response.PersonResponse;
import utils.Constants;

public class InsertPersonClass {
public static PersonResponse insertPerson(PersonModel model){
	PersonResponse response=new PersonResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="{CALL `UserSettings.Person_InsertPerson`(?,?,?)}";
		System.out.println("Query : "+query);
		String name=model.getName();
		int userProfileId=model.getUserProfileId();
		String companyCode=model.getCompanyCode();
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		callableStatement.setString(1, name);
		callableStatement.setInt(2, userProfileId);
		callableStatement.setString(3, companyCode);
		int count = callableStatement.executeUpdate();
		if(count>0){
			response=(GetPersonByUserProfileIdClass.getPersonByUserProfileId(userProfileId));
		}else{
			response.setIsSuccess(false);
			response.setMessage("Person is not inserted");
			response.setPersonList(null);
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(connection!=null){
			try{
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(callableStatement!=null){
			try{
				callableStatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	return response;
}
}
