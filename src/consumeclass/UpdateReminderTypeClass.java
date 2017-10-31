package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.ReminderTypeModel;
import response.ReminderTypeResponse;
import utils.Constants;

public class UpdateReminderTypeClass {
public static ReminderTypeResponse updateReminderType(ReminderTypeModel model){
	ReminderTypeResponse response=new ReminderTypeResponse();
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
		 int reminderTypeId=model.getReminderTypeId();
		 String reminderTypeName=model.getReminderTypeName();
		 boolean isactive=model.getIsActive();
		 
		 System.out.println(dateFormat.format(date));
		 String ModifiedDate=dateFormat.format(date);
		String query="{CALL `Settings.ReminderType_UpdateReminderType`(?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setInt(1,reminderTypeId );
		callstatement.setString(2, reminderTypeName);
		callstatement.setBoolean(3, isactive);
		callstatement.setString(4, ModifiedDate);
		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("ReminderType updated Successfully");
			response.setReminderTye(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("ReminderType is not updated or reminder type id is not exist");
			response.setReminderTye(null);
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
