package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dbconstants.ActivityTypeDBConstants;
import model.ActivityTypeModel;
import response.ActivityTypeResponse;
import utils.Constants;

public class GetActivityTypePipeDriveByUserProfielIdClass {
	private static ArrayList<ActivityTypeModel>activityTypeList=new ArrayList<ActivityTypeModel>();
public static ActivityTypeResponse getActivityTypeByUserProfileId(int UserProfileId){
	ActivityTypeResponse response=new ActivityTypeResponse();
	Connection connection=null;
	Statement st=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="CALL `UserSettings.ActivityTypes_GetActivityTypeByUserProfileId` ("+UserProfileId+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()){
			ActivityTypeModel model=new ActivityTypeModel();
			int activityTypeId=rs.getInt(ActivityTypeDBConstants.ACTIVITY_TYPE_ID);
			model.setActivityTypeId(activityTypeId);
			int orderNr=rs.getInt(ActivityTypeDBConstants.ORDER_NR);
			model.setOrderNr(orderNr);
			String name=rs.getString(ActivityTypeDBConstants.NAME);
			if(name==null){
				name="";
			}
			model.setName(name);
			String keyString=rs.getString(ActivityTypeDBConstants.KEY_STRING);
			if(keyString==null){
				keyString="";
			}
			model.setKeyString(keyString);
			String iconKey=rs.getString(ActivityTypeDBConstants.ICON_KEY);
			if(iconKey==null){
				iconKey="";
			}
			model.setIconKey(iconKey);
			boolean activeFlag=rs.getBoolean(ActivityTypeDBConstants.ACTIVE_FLAG);
			model.setActiveFlag(activeFlag);
			String color=rs.getString(ActivityTypeDBConstants.COLOR);
			if(color==null){
				color="";
			}
			model.setColor(color);
			boolean isCustomFlag=rs.getBoolean(ActivityTypeDBConstants.IS_CUSTOM_FLAG);
			model.setIsCustomFlag(isCustomFlag);
			String dateCreated=rs.getString(ActivityTypeDBConstants.DATE_CREATED);
			if(dateCreated==null){
				dateCreated="";
			}
			model.setDateCreated(dateCreated);
			String dateModified=rs.getString(ActivityTypeDBConstants.DATE_MODIFIED);
			if(dateModified==null){
				dateModified="";
			}
			model.setDateModified(dateModified);
			int userProfileId=rs.getInt(ActivityTypeDBConstants.USER_PROFILE_ID);
			model.setUserProfileId(userProfileId);
			
			
			GetActivityTypeClass.getActivityType().getActivityTypeList();
			ArrayList<ActivityTypeModel> val=GetActivityTypeClass.getActivityType().getActivityTypeList();
			if(val!=null && val.size()!=0){
				
			}
			
			
			activityTypeList.add(model);
			activityTypeList.addAll(GetActivityTypeClass.getActivityType().getActivityTypeList());
		}
		if(activityTypeList!=null && activityTypeList.size()!=0){
			response.setIsSuccess(true);
			response.setMessage("");
			response.setActivityTypeList(activityTypeList);
		}else{
			response=GetActivityTypeClass.getActivityType();
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
