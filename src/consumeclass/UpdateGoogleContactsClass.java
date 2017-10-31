package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.GoogleContactsModel;
import response.GoogleContactsResponse;
import utils.Constants;

public class UpdateGoogleContactsClass {
public static GoogleContactsResponse updateGoogleContacts(GoogleContactsModel model){
	GoogleContactsResponse response=new GoogleContactsResponse();
	Connection connection=null;
	CallableStatement callstatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		int contactId=model.getContactId();
		boolean isConnectedToGoogleAccount=model.getIsConnectedToGoogleAccount();
		String googleAccountEmail=model.getGoogleAccountEmail();
		boolean isActive=model.getIsActive();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 System.out.println(dateFormat.format(date));
		 String createdDate=dateFormat.format(date);
		String query="{CALL `UserSettings.GoogleContacts_UpdateGoogleContacts`(?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setInt(1,contactId );
		callstatement.setBoolean(2, isConnectedToGoogleAccount);
		callstatement.setString(3, googleAccountEmail);
		callstatement.setBoolean(4, isActive);
		callstatement.setString(5, createdDate);

		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("GoogleContacts List updated Successfully");
			response.setGoogleContactList(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("GoogleContacts is not updated or contact id is not exist");
			response.setGoogleContactList(null);
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
