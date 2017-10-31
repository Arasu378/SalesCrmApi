package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import response.ReminderTypeResponse;
import utils.Constants;
import model.ReminderTypeModel;

public class ReminderTypeClass {
	private static ArrayList<ReminderTypeModel>reminderList=new ArrayList<ReminderTypeModel>();
	public static ReminderTypeResponse getReminderType(){
		ReminderTypeResponse response =new ReminderTypeResponse();
		reminderList.clear();
		Connection connection=null;
		 java.sql.Statement st=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				String query="CALL  `Settings.ReminderType_GetReminderType`();";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				st=connection.createStatement();
				   ResultSet rs=st.executeQuery(query);
				   
				   while(rs.next()){
					   ReminderTypeModel model=new ReminderTypeModel();
					   int ReminderTypeId=rs.getInt(dbconstants.ReminderTypeDBConstants.REMINDER_TYPE_ID);
					   model.setReminderTypeId(ReminderTypeId);
					   String ReminderTypeName=rs.getString(dbconstants.ReminderTypeDBConstants.REMINDER_TYPE_NAME);
					   if(ReminderTypeName==null){
						   ReminderTypeName="";
					   }
					   model.setReminderTypeName(ReminderTypeName);
					   boolean IsActive=rs.getBoolean(dbconstants.ReminderTypeDBConstants.IS_ACTIVE);
					   model.setIsActive(IsActive);
					   String CreatedDate=rs.getString(dbconstants.ReminderTypeDBConstants.CREATED_DATE);
					 if(CreatedDate==null){
						 CreatedDate="";
					 }
					 model.setCreatedDate(CreatedDate);
					   String ModifiedDate=rs.getString(dbconstants.ReminderTypeDBConstants.MODIFIED_DATE);
					   if(ModifiedDate==null){
						   ModifiedDate="";
					   }
					   model.setModifiedDate(ModifiedDate);
					   reminderList.add(model);
				   }
				   if(reminderList!=null && reminderList.size()!=0){
					   response.setIsSuccess(true);
					   response.setMessage("");
					   response.setReminderTye(reminderList);
				   }else{
					   response.setIsSuccess(false);
					   response.setMessage("Reminder type list is empty or null");
					   response.setReminderTye(null);
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
