package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ReminderTimeModel;
import response.ReminderTimeResponse;
import utils.Constants;

public class ReminderTimeClass {
	private static ArrayList<ReminderTimeModel>reminderList=new ArrayList<ReminderTimeModel>();
	public static ReminderTimeResponse getReminderTime(){
		ReminderTimeResponse response=new ReminderTimeResponse();
		reminderList.clear();
		Connection connection=null;
		 java.sql.Statement st=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				String query="CALL  `Settings.ReminderTime_GetReminderTime`();";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				st=connection.createStatement();
				   ResultSet rs=st.executeQuery(query);
				   
				   while(rs.next()){
					   ReminderTimeModel model=new ReminderTimeModel();
					   int ReminderTimeId=rs.getInt(dbconstants.ReminderTimeDBConstants.REMINDER_TIME_ID);
					   model.setReminderTimeId(ReminderTimeId);
					   String ReminderTimeName=rs.getString(dbconstants.ReminderTimeDBConstants.REMINDER_TIME_NAME);
					 if(ReminderTimeName==null){
						 ReminderTimeName="";
					 }
					 model.setReminderTimeName(ReminderTimeName);
					   boolean  IsActive=rs.getBoolean(dbconstants.ReminderTimeDBConstants.IS_ACTIVE);
					   model.setIsActive(IsActive);
					   String CreatedDate=rs.getString(dbconstants.ReminderTimeDBConstants.CREATED_DATE);
					   if(CreatedDate==null){
						   CreatedDate="";
					   }
					   model.setCreatedDate(CreatedDate);
					   String ModifiedDate=rs.getString(dbconstants.ReminderTimeDBConstants.MODIFIED_DATE);
					   if(ModifiedDate==null){
						   ModifiedDate="";
					   }
					   model.setModifiedDate(ModifiedDate);
					   reminderList.add(model);
				   }
				   if(reminderList!=null && reminderList.size()!=0){
					   response.setIsSuccess(true);
					   response.setMessage("");
					   response.setReminderTime(reminderList);
				   }else{
					   response.setIsSuccess(false);
					   response.setMessage("ReminderList is empty or null");
					   response.setReminderTime(null);
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
				if(st!=null){
					try {
						st.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		return response;
	}

}
