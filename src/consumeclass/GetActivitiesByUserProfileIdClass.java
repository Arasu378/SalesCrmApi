package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dbconstants.ActivitiesDBConstants;
import model.ActivityModel;
import response.ActivityResponse;
import utils.Constants;

public class GetActivitiesByUserProfileIdClass {
	private static ArrayList<ActivityModel>activityList=new ArrayList<ActivityModel>();
public static ActivityResponse getActivitiesByUserProfileId(int UserProfileId){
	ActivityResponse response=new ActivityResponse();
	Connection connection=null;
	Statement st=null;
	activityList.clear();
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="CALL `UserSettings.Activity_GetAllActivityByUserProfileId`("+UserProfileId+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()){
			ActivityModel model=new ActivityModel();
			int activityId=rs.getInt(ActivitiesDBConstants.ACTIVITY_ID);
			model.setActivityId(activityId);
			int companyId=rs.getInt(ActivitiesDBConstants.COMPANY_ID);
			model.setCompanyId(companyId);
			int userProfileId=rs.getInt(ActivitiesDBConstants.USER_PROFILE_ID);
			model.setUserProfileId(userProfileId);
			boolean done=rs.getBoolean(ActivitiesDBConstants.DONE);
			model.setDone(done);
			String type=rs.getString(ActivitiesDBConstants.TYPE);
			if(type==null){
				type="";
			}
			model.setType(type);
			String referenceType=rs.getString(ActivitiesDBConstants.REFERENCE_TYPE);
			if(referenceType==null){
				referenceType="";
			}
			model.setReferenceType(referenceType);
			String referenceId=rs.getString(ActivitiesDBConstants.REFERENCE_ID);
			if(referenceId==null){
				referenceId="";
			}
			model.setReferenceId(referenceId);
			String dueDate=rs.getString(ActivitiesDBConstants.DUE_DATE);
			if(dueDate==null){
				dueDate="";
			}
			model.setDueDate(dueDate);
			String dueTime=rs.getString(ActivitiesDBConstants.DUE_TIME);
			if(dueTime==null){
				dueTime="";
			}
			model.setDueTime(dueTime);
			String duration=rs.getString(ActivitiesDBConstants.DURATION);
			if(duration==null){
				duration="";
			}
			model.setDuration(duration);
			String addTime=rs.getString(ActivitiesDBConstants.ADD_TIME);
			if(addTime==null){
				addTime="";
			}
			model.setAddTime(addTime);
			String markedAsDoneTime=rs.getString(ActivitiesDBConstants.MARKED_AS_DONE_TIME);
			if(markedAsDoneTime==null){
				markedAsDoneTime="";
			}
			model.setMarkedAsDoneTime(markedAsDoneTime);
			String subject=rs.getString(ActivitiesDBConstants.SUBJECT);
			if(subject==null){
				subject="";
			}
			model.setSubject(subject);
			int  orgId=rs.getInt(ActivitiesDBConstants.ORG_ID);
			model.setOrgId(orgId);
			int personId=rs.getInt(ActivitiesDBConstants.PERSON_ID);
			model.setPersonId(personId);
			int dealId=rs.getInt(ActivitiesDBConstants.DEAL_ID);
			model.setDealId(dealId);
			boolean activeFlag=rs.getBoolean(ActivitiesDBConstants.ACTIVE_FLAG);
			model.setActiveFlag(activeFlag);
			String updateTime=rs.getString(ActivitiesDBConstants.UPDATE_TIME);
			if(updateTime==null){
				updateTime="";
			}
			model.setUpdateTime(updateTime);
			String gCalEventId=rs.getString(ActivitiesDBConstants.G_CAL_EVENT_ID);
			if(gCalEventId==null){
				gCalEventId="";
			}
			model.setGCalEventId(gCalEventId);
			String googleCalendarId=rs.getString(ActivitiesDBConstants.GOOGLE_CALENDAR_ID);
			if(googleCalendarId==null){
				googleCalendarId="";
			}
			model.setGoogleCalendarId(googleCalendarId);
			String googleCalendarETag=rs.getString(ActivitiesDBConstants.GOOGLE_CALENDAR_ETAG);
			if(googleCalendarETag==null){
				googleCalendarETag="";
			}
			model.setGoogleCalendarETag(googleCalendarETag);

			String note=rs.getString(ActivitiesDBConstants.NOTE);
			if(note==null){
				note="";
			}
			model.setNote(note);
			int createdByUserProfileId=rs.getInt(ActivitiesDBConstants.CREATED_BY_USER_PROFILE_ID);
			model.setCreatedByUserProfileId(createdByUserProfileId);
			String participants=rs.getString(ActivitiesDBConstants.PARTICIPANTS);
			if(participants==null){
				participants="";
			}
			model.setParticipants(participants);
			String orgName=rs.getString(ActivitiesDBConstants.ORG_NAME);
			if(orgName==null){
				orgName="";
			}
			model.setOrgName(orgName);
			String personName=rs.getString(ActivitiesDBConstants.PERSON_NAME);
			if(personName==null){
				personName="";
			}
			model.setPersonName(personName);
			String dealTitle=rs.getString(ActivitiesDBConstants.DEAL_TITLE);
			if(dealTitle==null){
				dealTitle="";
			}
			model.setDealTitle(dealTitle);
			String ownerName=rs.getString(ActivitiesDBConstants.OWNER_NAME);
			if(ownerName==null){
				ownerName="";
			}
			model.setOwnerName(ownerName);
			String personDropBoxBcc=rs.getString(ActivitiesDBConstants.PERSON_DROP_BOX_BCC);
			if(personDropBoxBcc==null){
				personDropBoxBcc="";
			}
			model.setPersonDropBoxBcc(personDropBoxBcc);
			String dealDropBoxBcc=rs.getString(ActivitiesDBConstants.DEAL_DROP_BOX_BCC);
			if(dealDropBoxBcc==null){
				dealDropBoxBcc="";
			}
			model.setDealDropBoxBcc(dealDropBoxBcc);
			int assignedToUserProfileId=rs.getInt(ActivitiesDBConstants.ASSIGNED_TO_USER_PROFILE_ID);
			model.setAssignedToUserProfileId(assignedToUserProfileId);
			activityList.add(model);
			
		}
		if(activityList!=null && activityList.size()!=0){
			response.setIsSuccess(true);
			response.setMessage("");
			response.setActivityList(activityList);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Activity list is empty or null");
			response.setActivityList(null);
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
