package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.GoogleContactsModel;
import response.GoogleContactsResponse;
import utils.Constants;

public class InsertGoogleContactsClass {
public static GoogleContactsResponse insertGoogleContacts(GoogleContactsModel model){
	GoogleContactsResponse response=new GoogleContactsResponse();
	 Connection connection=null;
		CallableStatement callstatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="{CALL  `UserSettings.GoogleContacts_InsertGoogleContacts`(?,?,?,?)}";
			System.out.println("Query : "+query);
			int userProfileId=model.getUserProfileId();
			boolean isConnectedToGoogleAccount=model.getIsConnectedToGoogleAccount();
			String googleAccountEmail=model.getGoogleAccountEmail();
			boolean IsActive=model.getIsActive();
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callstatement = connection.prepareCall(query);
			callstatement.setInt(1,userProfileId );
			callstatement.setBoolean(2, isConnectedToGoogleAccount);
			callstatement.setString(3, googleAccountEmail);
			callstatement.setBoolean(4, IsActive);
			int count = callstatement.executeUpdate();
			if(count>0){
				response.setIsSuccess(true);
				response.setMessage("GoogleContacts inserted Successfully");
				response.setGoogleContactList(null);
			}else{
				response.setIsSuccess(false);
				response.setMessage("GoogleContacts is not inserted");
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
