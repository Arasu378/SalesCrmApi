package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconstants.GoogleDriveDBConstants;
import model.GoogleDriveModel;
import response.GoogleDriveResponse;
import utils.Constants;

public class GetGoogleDriveClass {
	private static ArrayList<GoogleDriveModel>googleDriveList=new ArrayList<GoogleDriveModel>();
public static GoogleDriveResponse getGoogleDrive(int DriveId){
	GoogleDriveResponse response=new GoogleDriveResponse();
	googleDriveList.clear();
	 Connection connection=null;
	 java.sql.Statement st=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		
		String query="CALL `UserSettings.GoogleDrive_GetGoogleDriveByDriveId`("+DriveId+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   
		   while(rs.next()){
			   GoogleDriveModel gooModel=new GoogleDriveModel();
			  int driveId=rs.getInt(GoogleDriveDBConstants.DRIVE_ID);
			  int userProfileId=rs.getInt(GoogleDriveDBConstants.USER_PROFILE_ID);
			  boolean isConnectedToGoogleAccount=rs.getBoolean(GoogleDriveDBConstants.IS_CONNECTED_TO_GOOGLE_ACCOUNT);
			  String googleAccountEmail=rs.getString(GoogleDriveDBConstants.GOOGLE_ACCOUNT_EMAIL);
			  if(googleAccountEmail==null){
				  googleAccountEmail="";
			  }
			  boolean isActive=rs.getBoolean(GoogleDriveDBConstants.IS_ACTIVE);
			  String createdDate=rs.getString(GoogleDriveDBConstants.CREATED_DATE);
			  if(createdDate==null){
				  createdDate="";
			  }
			 gooModel.setDriveId(driveId);
			 gooModel.setUserProfileId(userProfileId);
			 gooModel.setIsConnectedToGoogleAccount(isConnectedToGoogleAccount);
			 gooModel.setGoogleAccountEmail(googleAccountEmail);
			 gooModel.setIsActive(isActive);
			 gooModel.setCreatedDate(createdDate);
			 googleDriveList.add(gooModel);
		   }
		   if(googleDriveList!=null&&googleDriveList.size()!=0){
			   response.setIsSuccess(true);
			   response.setMessage("");
			   response.setGoogleDriveList(googleDriveList);
		   }else{
			   response.setIsSuccess(false);
			   response.setMessage("GoogleDrive List is Empty or Null!");
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
