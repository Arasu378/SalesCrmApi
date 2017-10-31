package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.ReminderTimeModel;
import response.ReminderTimeResponse;
import utils.Constants;

public class UpdateReminderTimeClass {
public static ReminderTimeResponse updateReminderTime(ReminderTimeModel model){
	ReminderTimeResponse response=new ReminderTimeResponse();
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
		 int reminderTimeId=model.getReminderTimeId();
		 String reminderTimeName=model.getReminderTimeName();
		 boolean isactive=model.getIsActive();
		 
		 System.out.println(dateFormat.format(date));
		 String ModifiedDate=dateFormat.format(date);
		String query="{CALL `Settings.ReminderTime_UpdateReminderTime`(?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setInt(1,reminderTimeId );
		callstatement.setString(2, reminderTimeName);
		callstatement.setBoolean(3, isactive);
		callstatement.setString(4, ModifiedDate);
		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("ReminderTime updated Successfully");
			response.setReminderTime(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("ReminderTime is not updated or reminder time id is not exist");
			response.setReminderTime(null);
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
