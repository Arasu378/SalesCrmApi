package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.ReminderTimeModel;
import response.ReminderTimeResponse;
import utils.Constants;

public class InsertReminderTimeClass {
public static ReminderTimeResponse insertReminderTime(ReminderTimeModel model){
	ReminderTimeResponse response=new ReminderTimeResponse();
	Connection connection=null;
		CallableStatement callstatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="{CALL `Settings.ReminderTime_InsertReminderTime`(?)}";
		System.out.println("Query : "+query);
		String reminderTimename=model.getReminderTimeName();
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setString(1,reminderTimename );
		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("ReminderTime inserted Successfully");
			response.setReminderTime(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("ReminderTime is not inserted");
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
