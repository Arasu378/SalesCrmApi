package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.ReminderEmailModel;
import response.ReminderEmailResponse;
import utils.Constants;

public class UpdateReminderEmailClass {
public static ReminderEmailResponse updateReminderEmail(ReminderEmailModel model){
	ReminderEmailResponse response=new ReminderEmailResponse();
	Connection connection=null;
	CallableStatement callstatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		int reminderEmailId=model.getReminderEmailId();
		String reminderTypeId=model.getReminderTypeId();
		String reminderTimeId=model.getReminderTimeId();
		 boolean isactive=model.getIsActive();
		 
		 System.out.println(dateFormat.format(date));
		 String ModifiedDate=dateFormat.format(date);
		String query="{CALL `UserSettings.ReminderEmails._UpdateReminderEmail`(?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setInt(1,reminderEmailId );
		callstatement.setString(2, reminderTypeId);
		callstatement.setString(3, reminderTimeId);
		callstatement.setBoolean(4, isactive);
		callstatement.setString(5, ModifiedDate);
		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("ReminderEmail updated Successfully");
			response.setReminderEmailList(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("ReminderEmail is not updated or reminder email id is not exist");
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
		if(callstatement!=null){
			try{
				callstatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	return response;
}
}
