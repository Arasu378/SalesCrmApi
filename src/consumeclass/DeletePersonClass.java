package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.PersonModel;
import response.PersonResponse;
import utils.Constants;

public class DeletePersonClass {
public static PersonResponse deletePerson(PersonModel model){
	PersonResponse response=new PersonResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="{CALL `UserSettings.Person_DeletePerson`(?)}";
		System.out.println("Query : "+query);
		int personId=model.getPersonId();
		int userProfileId=model.getUserProfileId();
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		callableStatement.setInt(1, personId);
		int count = callableStatement.executeUpdate();
		if(count>0){
			response=(GetPersonByUserProfileIdClass.getPersonByUserProfileId(userProfileId));
		}else{
			response.setIsSuccess(false);
			response.setMessage("Person is not deleted");
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
