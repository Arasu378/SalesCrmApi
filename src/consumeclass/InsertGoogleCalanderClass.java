package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.GoogleCalanderModel;
import response.GoogleCalanderResponse;
import utils.Constants;

public class InsertGoogleCalanderClass {
public static GoogleCalanderResponse insertGoogleCalander(GoogleCalanderModel model){
	GoogleCalanderResponse response=new GoogleCalanderResponse();
	Connection connection=null;
		CallableStatement callstatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		int profileId=model.getUserProfileId();
		boolean isConnectedToGoogleAccount=model.getIsConnectedToGoogleAccount();
		String googleAccountEmail=model.getGoogleAccountEmail();
		boolean isActive=model.getIsActive();
		
		
		String query="{CALL  `UserSettings.GoogleCalendar_InsertGoogleCalendar`(?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setInt(1, profileId);
		callstatement.setBoolean(2, isConnectedToGoogleAccount);
		callstatement.setString(3,googleAccountEmail );
		callstatement.setBoolean(4, isActive);
		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("GoogleCalander inserted Successfully");
			response.setGoogleCalanderList(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("GoogleCalander is not inserted");
			response.setGoogleCalanderList(null);
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
