package consumeclass;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dbconstants.ActivityTypeDBConstants;
import model.ActivityTypeModel;
import response.ActivityResponse;
import response.ActivityTypeResponse;
import utils.Constants;

public class GetActivityTypeClass {
	private static ArrayList<ActivityTypeModel>activityTypeList=new ArrayList<ActivityTypeModel>();
	public static ActivityTypeResponse getActivityType(){
		ActivityTypeResponse response=new ActivityTypeResponse();
		Connection connection=null;
		Statement st=null;
		activityTypeList.clear();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="Call `UserSettings.ActivityType_GetActivityTypes`(); ";
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
				
				
				
				activityTypeList.add(model);
				
			}
			if(activityTypeList!=null && activityTypeList.size()!=0){
				response.setIsSuccess(true);
				response.setMessage("");
				response.setActivityTypeList(activityTypeList);
			}else{
				response.setIsSuccess(false);
				response.setMessage("Activity type is empty or null");
				response.setActivityTypeList(null);
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
