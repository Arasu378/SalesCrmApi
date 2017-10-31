package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.ReminderEmailModel;
import response.ReminderEmailResponse;
import utils.Constants;

public class DeleteReminderEmailClass {
public static ReminderEmailResponse deleteReminder(ReminderEmailModel model){
	ReminderEmailResponse response=new ReminderEmailResponse();
	Connection connection=null;
	 java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int reminderEmailId=model.getReminderEmailId();
			String query="CALL   `UserSettings.ReminderEmails_DeleteReminderEmail`("+reminderEmailId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	           PreparedStatement stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           if(i>0){
	        	   response.setReminderEmailList(null);
	        	   response.setIsSuccess(true);
	        	   response.setMessage("Successfully deleted ");
	           }else{
	        	   response.setReminderEmailList(null);
	        	   response.setIsSuccess(false);
	        	   response.setMessage("Not deleted  or reminder email id does not exist");
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
