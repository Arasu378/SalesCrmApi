package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.ReminderEmailModel;
import response.ReminderEmailResponse;
import utils.Constants;

public class InsertReminderEmailClass {
public static ReminderEmailResponse insertReminderEmail(ReminderEmailModel model){
	ReminderEmailResponse response =new ReminderEmailResponse();
	Connection connection=null;
	CallableStatement callstatement=null;
try {
	Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e1) {
	e1.printStackTrace();
}
try{
	String query="{CALL  `UserSettings.ReminderEmail_InsertReminderEmail`(?,?,?,?)}";
	System.out.println("Query : "+query);
	int profileId=model.getUserProfileId();
	String reminderTypeId=model.getReminderTypeId();
	String reminderTimeId=model.getReminderTimeId();
	boolean isActive=model.getIsActive();
	connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	callstatement = connection.prepareCall(query);
	callstatement.setInt(1,profileId );
	callstatement.setString(2,reminderTypeId );
	callstatement.setString(3,reminderTimeId );
	callstatement.setBoolean(4,isActive );
	int count = callstatement.executeUpdate();
	if(count>0){
		response.setIsSuccess(true);
		response.setMessage("ReminderEmail inserted Successfully");
		response.setReminderEmailList(null);
	}else{
		response.setIsSuccess(false);
		response.setMessage("ReminderEmail is not inserted");
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
