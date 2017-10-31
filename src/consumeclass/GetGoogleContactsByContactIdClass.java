package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconstants.GoogleContactsDBConstant;
import dbconstants.ReminderEmailDBConstants;
import model.GoogleContactsModel;
import response.GoogleContactsResponse;
import utils.Constants;

public class GetGoogleContactsByContactIdClass {
	private static ArrayList<GoogleContactsModel>googleContactsList=new ArrayList<GoogleContactsModel>();
public static GoogleContactsResponse getGoogleContacts(int ContactId){
	GoogleContactsResponse response=new GoogleContactsResponse();
	googleContactsList.clear();
	 Connection connection=null;
	 java.sql.Statement st=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		
		String query="CALL `UserSettings.GoogleContacts_GetGoogleContactsbyContactId`("+ContactId+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   
		   while(rs.next()){
			   GoogleContactsModel conModel=new GoogleContactsModel();
			  int contactId=rs.getInt(GoogleContactsDBConstant.CONTACT_ID);
			  int userProfileId=rs.getInt(GoogleContactsDBConstant.USER_PROFILE_ID);
			  String googleAccountEmail=rs.getString(GoogleContactsDBConstant.GOOGLE_ACCOUNT_EMAIL);
			  if(googleAccountEmail==null){
				  googleAccountEmail="";
			  }
			  boolean isConnectedToGoogleAccount=rs.getBoolean(GoogleContactsDBConstant.IS_CONNECTED_TO_GOOGLE_ACCOUNT);
			   boolean isActive=rs.getBoolean(ReminderEmailDBConstants.IS_ACTIVE);
			  String createdDate=rs.getString(ReminderEmailDBConstants.CREATED_DATE);
			  if(createdDate==null){
				  createdDate="";
			  }
			  conModel.setContactId(contactId);
			  conModel.setUserProfileId(userProfileId);
			  conModel.setGoogleAccountEmail(googleAccountEmail);
			  conModel.setIsConnectedToGoogleAccount(isConnectedToGoogleAccount);
			  conModel.setIsActive(isActive);
			  conModel.setCreatedDate(createdDate);
			 
			  googleContactsList.add(conModel);
		   }
		   if(googleContactsList!=null&&googleContactsList.size()!=0){
			   response.setIsSuccess(true);
			   response.setMessage("");
			   response.setGoogleContactList(googleContactsList);
		   }else{
			   response.setIsSuccess(false);
			   response.setMessage("GoogleContact list is Empty or Null!");
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
		if(st!=null){
			try{
				st.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	return response;
}
}
