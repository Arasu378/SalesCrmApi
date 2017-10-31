package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconstants.ConnectionsDBConstants;
import model.ConnectionsModel;
import response.ConnectionsResponse;
import utils.Constants;

public class GetConnectionsByUserProfileIdClass {
	private static ArrayList<ConnectionsModel>connectionList=new ArrayList<ConnectionsModel>();
	public static ConnectionsResponse getConnection(int UserProfileId){
	ConnectionsResponse response=new ConnectionsResponse();
	connectionList.clear();
	 Connection connection=null;
	 java.sql.Statement st=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
try{
		
		String query="CALL  `UserSettings.Connections_GetConnectionsByUserprofileid`("+UserProfileId+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   
		   while(rs.next()){
			   ConnectionsModel conModel=new ConnectionsModel();
			  int connectionId=rs.getInt(ConnectionsDBConstants.CONNECTION_ID);
			  int userProfileId=rs.getInt(ConnectionsDBConstants.USER_PROFILE_ID);
			  boolean isConnectedToGoogleAccount=rs.getBoolean(ConnectionsDBConstants.IS_CONNECTED_TO_GOOGLE_ACCOUNT);
			  boolean isConnectedToMailChimpAccount=rs.getBoolean(ConnectionsDBConstants.IS_CONNECTED_TO_MAIL_CHIMP_ACCOUNT);
			  String googleAccountEmail=rs.getString(ConnectionsDBConstants.GOOGLE_ACCOUNT_EMAIL);
			  if(googleAccountEmail==null){
				  googleAccountEmail="";
			  }
			  String mailChimpAccountEmail=rs.getString(ConnectionsDBConstants.MAIL_CHIMP_ACCOUNT_EMAIL);
			  if(mailChimpAccountEmail==null){
				  mailChimpAccountEmail="";
			  }
			  boolean isActive=rs.getBoolean(ConnectionsDBConstants.IS_ACTIVE);
			  String createdDate=rs.getString(ConnectionsDBConstants.CREATED_DATE);
			  if(createdDate==null){
				  createdDate="";
			  }
			  String modifiedDate=rs.getString(ConnectionsDBConstants.MODIFIED_DATE);
			  if(modifiedDate==null){
				  modifiedDate="";
			  }
			  conModel.setConnectionId(connectionId);
			  conModel.setUserProfileId(userProfileId);
			  conModel.setIsConnectedToGoogleAccount(isConnectedToGoogleAccount);
			  conModel.setIsConnectedToMailChimpAccount(isConnectedToMailChimpAccount);
			  conModel.setGoogleAccountEmail(googleAccountEmail);
			  conModel.setMailChimpAccountEmail(mailChimpAccountEmail);
			  conModel.setIsActive(isActive);
			  conModel.setCreatedDate(createdDate);
			  conModel.setModifiedDate(modifiedDate);
			  
			  
			   connectionList.add(conModel);
		   }
		   if(connectionList!=null&&connectionList.size()!=0){
			   response.setIsSuccess(true);
			   response.setMessage("");
			   response.setConnectionList(connectionList);
		   }else{
			   response.setIsSuccess(false);
			   response.setMessage("Connection List is Empty or Null!");
			   response.setConnectionList(null);
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
