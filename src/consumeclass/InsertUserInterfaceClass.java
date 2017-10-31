package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.UserInterfaceModel;
import response.UserInterfaceResponse;
import utils.Constants;

public class InsertUserInterfaceClass {
public static UserInterfaceResponse insertUserInterface(UserInterfaceModel model){
	UserInterfaceResponse response=new UserInterfaceResponse();
	Connection connection=null;
		CallableStatement callstatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="{CALL `UserSettings.UserInterface_InsertUserInterface`(?,?,?,?,?)}";
		System.out.println("Query : "+query);
		int profileId=model.getUserProfileId();
		boolean isDeal=model.getIsDeal();
		boolean isPerson=model.getIsPerson();
		boolean isOrganisation=model.getIsOrganization();
		boolean isActive=model.getIsActive();
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setInt(1,profileId );
		callstatement.setBoolean(2, isDeal);
		callstatement.setBoolean(3, isPerson);
		callstatement.setBoolean(4, isOrganisation);
		callstatement.setBoolean(5, isActive);
		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("UserInterface inserted Successfully");
			response.setUserInterfaceList(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("UserInterface is not inserted");
			response.setUserInterfaceList(null);
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
		if(callstatement!=null){
			try{
				callstatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	return response;
}
}
