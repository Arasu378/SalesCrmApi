package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.ReminderTypeModel;
import response.ReminderTypeResponse;
import utils.Constants;

public class InsertReminderTypeClass {
public static ReminderTypeResponse insertReminderType(ReminderTypeModel model){
	ReminderTypeResponse response=new ReminderTypeResponse();
	Connection connection=null;
	CallableStatement callstatement=null;
try {
	Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e1) {
	e1.printStackTrace();
}
try{
	String query="{CALL `Settings.ReminderType_InsertReminderType`(?)}";
	System.out.println("Query : "+query);
	String reminderTypename=model.getReminderTypeName();
	connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	callstatement = connection.prepareCall(query);
	callstatement.setString(1,reminderTypename );
	int count = callstatement.executeUpdate();
	if(count>0){
		response.setIsSuccess(true);
		response.setMessage("ReminderType inserted Successfully");
		response.setReminderTye(null);
	}else{
		response.setIsSuccess(false);
		response.setMessage("ReminderType is not inserted");
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
