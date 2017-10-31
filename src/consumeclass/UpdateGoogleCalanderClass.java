package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.GoogleCalanderModel;
import response.GoogleCalanderResponse;
import utils.Constants;

public class UpdateGoogleCalanderClass {
public static GoogleCalanderResponse updateGoogleCalander(GoogleCalanderModel model){
	GoogleCalanderResponse response=new GoogleCalanderResponse();
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
		 int connectionId=model.getConnectionId();
		 boolean isConnectedToGoogleAccount=model.getIsConnectedToGoogleAccount();
		 String googleAccountEmail=model.getGoogleAccountEmail();
		 boolean isactive=model.getIsActive();
		 
		 System.out.println(dateFormat.format(date));
		 String createdDate=dateFormat.format(date);
		String query="{CALL   `UserSettings.GoogleCalendar_UpdateGoogleCalendar`(?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setInt(1,connectionId );
		callstatement.setBoolean(2, isConnectedToGoogleAccount);
		callstatement.setString(3, googleAccountEmail);
		callstatement.setBoolean(4, isactive);
		callstatement.setString(5, createdDate);
		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("GoogleCalander updated Successfully");
			response.setGoogleCalanderList(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("GoogleCalander is not updated or connection id is not existed");
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
