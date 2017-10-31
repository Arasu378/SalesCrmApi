package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.ActivityModel;
import response.ActivityResponse;
import utils.Constants;

public class UpdateActivityClass {
public static ActivityResponse updateActivity(ActivityModel model){
	ActivityResponse response=new ActivityResponse();

	Connection connection=null;
	CallableStatement callableStatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="{CALL `UserSettings.Activity_UpdateActivity`(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		int userProfileId=model.getUserProfileId();
		boolean done=model.getDone();
		callableStatement.setBoolean(1, done);
		String type=model.getType();
		callableStatement.setString(2, type);
		String referenceType=model.getReferenceType();
		callableStatement.setString(3, referenceType);
		String referenceId=model.getReferenceId();
		callableStatement.setString(4, referenceId);
		String dueDate=model.getDueDate();
		callableStatement.setString(5, dueDate);
		String dueTime=model.getDueTime();
		callableStatement.setString(6, dueTime);
		String duration=model.getDuration();
		callableStatement.setString(7, duration);
		String markedAsDoneTime=model.getMarkedAsDoneTime();
		callableStatement.setString(8, markedAsDoneTime);
		String subject=model.getSubject();
		callableStatement.setString(9, subject);
		int orgId=model.getOrgId();
		callableStatement.setInt(10, orgId);
		int personId=model.getPersonId();
		callableStatement.setInt(11, personId);
		int dealId=model.getDealId();
		callableStatement.setInt(12, dealId);
		boolean activeFlag=model.getActiveFlag();
		callableStatement.setBoolean(13, activeFlag);
		String updateTime=model.getUpdateTime();
		callableStatement.setString(14, updateTime);
		String gCalEventId=model.getGCalEventId();
		callableStatement.setString(15, gCalEventId);
		String googleCalendarId=model.getGoogleCalendarId();
		callableStatement.setString(16, googleCalendarId);
		String googleCalendarETag=model.getGoogleCalendarETag();
		callableStatement.setString(17, googleCalendarETag);
		String note=model.getNote();
		callableStatement.setString(18, note);
		int createdByUserProfileId=model.getCreatedByUserProfileId();
		callableStatement.setInt(19, createdByUserProfileId);
		String participants=model.getParticipants();
		callableStatement.setString(20, participants);
		String orgName=model.getOrgName();
		callableStatement.setString(21, orgName);
		String personName=model.getPersonName();
		callableStatement.setString(22, personName);
		String dealTitle=model.getDealTitle();
		callableStatement.setString(23, dealTitle);
		String ownerName=model.getOwnerName();
		callableStatement.setString(24, ownerName);
		String personDropBoxBcc=model.getPersonDropBoxBcc();
		callableStatement.setString(25, personDropBoxBcc);
		String dealDropBoxBcc=model.getDealDropBoxBcc();
		callableStatement.setString(26, dealDropBoxBcc);
		int assignedToUserProfileId=model.getAssignedToUserProfileId();
		callableStatement.setInt(27, assignedToUserProfileId);
		int activityId=model.getActivityId();
		callableStatement.setInt(28, activityId);
		
		int count = callableStatement.executeUpdate();
		if(count>0){
			response=GetActivitiesByUserProfileIdClass.getActivitiesByUserProfileId(userProfileId);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Activity is not inserted");
			response.setActivityList(null);
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(connection!=null){
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(callableStatement!=null){
			try {
				callableStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	return response;
}
}
