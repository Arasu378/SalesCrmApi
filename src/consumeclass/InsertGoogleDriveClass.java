package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.GoogleDriveModel;
import response.GoogleDriveResponse;
import utils.Constants;

public class InsertGoogleDriveClass {
public static GoogleDriveResponse insertGoogleDrive(GoogleDriveModel model){
	GoogleDriveResponse response=new GoogleDriveResponse();
	
	Connection connection=null;
		CallableStatement callstatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="{CALL `UserSettings.GoogleDrive_InsertGoogleDrive`(?,?,?,?)}";
		System.out.println("Query : "+query);
		int profileId=model.getUserProfileId();
		boolean isConnectedGoogle=model.getIsConnectedToGoogleAccount();
		String email=model.getGoogleAccountEmail();
		boolean isActive=model.getIsActive();
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setInt(1,profileId );
		callstatement.setBoolean(2, isConnectedGoogle);
		callstatement.setString(3, email);
		callstatement.setBoolean(4, isActive);
		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("GoogleDrive inserted Successfully");
			response.setGoogleDriveList(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("GoogleDrive is not inserted");
			response.setGoogleDriveList(null);
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
