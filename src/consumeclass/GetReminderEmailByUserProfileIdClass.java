package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconstants.ProfilePictureDBConstants;
import dbconstants.ReminderEmailDBConstants;
import model.ProfilePictureModel;
import model.ReminderEmailModel;
import response.ReminderEmailResponse;
import utils.Constants;

public class GetReminderEmailByUserProfileIdClass {
	private static ArrayList<ReminderEmailModel>reminderEmailList=new ArrayList<ReminderEmailModel>();
public static ReminderEmailResponse getReminderEmail(int UserProfileId){
	ReminderEmailResponse response=new ReminderEmailResponse();
	reminderEmailList.clear();
	 Connection connection=null;
	 java.sql.Statement st=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		
		String query="CALL `UserSettings.ReminderEmails_GetReminderEmailsbyUserProfileId`("+UserProfileId+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   
		   while(rs.next()){
			   ReminderEmailModel remModel=new ReminderEmailModel();
			  int reminderEmailId=rs.getInt(ReminderEmailDBConstants.REMINDER_EMAIL_ID);
			  int userProfileId=rs.getInt(ReminderEmailDBConstants.USER_PROFILE_ID);
			  String reminderTypeId=rs.getString(ReminderEmailDBConstants.REMINDER_TYPE_ID);
			  String reminderTimeId=rs.getString(ReminderEmailDBConstants.REMINDER_TIME_ID);
			  boolean isActive=rs.getBoolean(ReminderEmailDBConstants.IS_ACTIVE);
			  String createdDate=rs.getString(ReminderEmailDBConstants.CREATED_DATE);
			  if(createdDate==null){
				  createdDate="";
			  }
			  String modifiedDate=rs.getString(ReminderEmailDBConstants.MODIFIED_DATE);
			  if(modifiedDate==null){
				  modifiedDate="";
			  }
			  remModel.setReminderEmailId(reminderEmailId);
			  remModel.setUserProfileId(userProfileId);
			  remModel.setReminderTypeId(reminderTypeId);
			  remModel.setReminderTimeId(reminderTimeId);
			  remModel.setIsActive(isActive);
			  remModel.setCreatedDate(createdDate);
			  remModel.setModifiedDate(modifiedDate);
			  reminderEmailList.add(remModel);
		   }
		   if(reminderEmailList!=null&&reminderEmailList.size()!=0){
			   response.setIsSuccess(true);
			   response.setMessage("");
			   response.setReminderEmailList(reminderEmailList);
		   }else{
			   response.setIsSuccess(false);
			   response.setMessage("ReminderEmailList is Empty or Null!");
			   response.setReminderEmailList(null);
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
