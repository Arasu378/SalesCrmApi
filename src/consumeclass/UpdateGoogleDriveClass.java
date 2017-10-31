package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.GoogleDriveModel;
import response.GoogleDriveResponse;
import utils.Constants;

public class UpdateGoogleDriveClass {
public static GoogleDriveResponse updateGoogleDrive(GoogleDriveModel model){
	GoogleDriveResponse response=new GoogleDriveResponse();
	Connection connection=null;
	CallableStatement callstatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 int driveId=model.getDriveId();
		 boolean isConnectedGoogle=model.getIsConnectedToGoogleAccount();
		 String email=model.getGoogleAccountEmail();
		 boolean isactive=model.getIsActive();
		 
		 System.out.println(dateFormat.format(date));
		 String ModifiedDate=dateFormat.format(date);
		String query="{CALL  `UserSettings.GoogleDrive_UpdateGoogleDrive`(?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setInt(1,driveId );
		callstatement.setBoolean(2, isConnectedGoogle);
		callstatement.setString(3, email);
		callstatement.setBoolean(4, isactive);
		callstatement.setString(5, ModifiedDate);
		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("GoogleDrive updated Successfully");
			response.setGoogleDriveList(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("GoogleDrive is not updated or drive id is not exist");
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
