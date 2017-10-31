package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconstants.GoogleCalanderDBConstants;
import model.GoogleCalanderModel;
import response.GoogleCalanderResponse;
import utils.Constants;

public class GetGoogleCalanderByConnectionIdClass {
	private static ArrayList<GoogleCalanderModel>googleCalanderList=new ArrayList<GoogleCalanderModel>();
public static GoogleCalanderResponse getGoogleCalendar(int ConnectionId){
	GoogleCalanderResponse response=new GoogleCalanderResponse();
	googleCalanderList.clear();
	 Connection connection=null;
	 java.sql.Statement st=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		
		String query="CALL  `UsersSettings.GoogleCalendar_GetGoogleCalendarbyConnectionId`("+ConnectionId+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   
		   while(rs.next()){
			   GoogleCalanderModel gooModel=new GoogleCalanderModel();
			  int connectionId=rs.getInt(GoogleCalanderDBConstants.CONNECTION_ID);
			  int userProfileId=rs.getInt(GoogleCalanderDBConstants.USER_PROFILE_ID);
			  boolean isConnectedToGoogleAccount=rs.getBoolean(GoogleCalanderDBConstants.IS_CONNECTED_TO_GOOGLE_ACCOUNT);
			  boolean isActive=rs.getBoolean(GoogleCalanderDBConstants.IS_ACTIVE);
			  String googleAccountEmail=rs.getString(GoogleCalanderDBConstants.GOOGLE_ACCOUNT_EMAIL);
			  if(googleAccountEmail==null){
				  googleAccountEmail="";
			  }
			  String createdDate=rs.getString(GoogleCalanderDBConstants.CREATED_DATE);
			  if(createdDate==null){
				  createdDate="";
			  }
			  gooModel.setConnectionId(connectionId);
			  gooModel.setUserProfileId(userProfileId);
			  gooModel.setIsConnectedToGoogleAccount(isConnectedToGoogleAccount);
			  gooModel.setIsActive(isActive);
			  gooModel.setGoogleAccountEmail(googleAccountEmail);
			  gooModel.setCreatedDate(createdDate);
			  
			  googleCalanderList.add(gooModel);
		   }
		   if(googleCalanderList!=null&&googleCalanderList.size()!=0){
			   response.setIsSuccess(true);
			   response.setMessage("");
			   response.setGoogleCalanderList(googleCalanderList);
		   }else{
			   response.setIsSuccess(false);
			   response.setMessage("GoogleCalander List is Empty or Null!");
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
