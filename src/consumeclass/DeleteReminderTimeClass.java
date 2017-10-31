package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.ReminderTimeModel;
import response.ReminderTimeResponse;
import utils.Constants;

public class DeleteReminderTimeClass {
public static ReminderTimeResponse deleteReminderTime(ReminderTimeModel model){
	ReminderTimeResponse response=new ReminderTimeResponse();
	Connection connection=null;
	 java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int reminderTimeId=model.getReminderTimeId();
			String query="CALL  `Settings.ReminderTime_DeleteReminderTime`("+reminderTimeId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	           PreparedStatement stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           if(i>0){
	        	   response.setReminderTime(null);
	        	   response.setIsSuccess(true);
	        	   response.setMessage("Successfully deleted ");
	           }else{
	        	   response.setReminderTime(null);
	        	   response.setIsSuccess(false);
	        	   response.setMessage("Not deleted or reminder time id does not exist ");
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
