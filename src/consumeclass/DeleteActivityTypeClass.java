package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.ActivityTypeModel;
import response.ActivityTypeResponse;
import utils.Constants;

public class DeleteActivityTypeClass {
public static ActivityTypeResponse deleteActivityType(ActivityTypeModel model){
	ActivityTypeResponse response=new ActivityTypeResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="{CALL `UserSettings.ActivityTypes_DeleteActivityType`(?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		int activityTypeId=model.getActivityTypeId();
		callableStatement.setInt(1, activityTypeId);

		int count = callableStatement.executeUpdate();
		
		if(count>0){
			response=GetActivityTypeClass.getActivityType();
		}else{
			response.setIsSuccess(false);
			response.setMessage("Activity Type is not Deleted");
			response.setActivityTypeList(null);
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
		if(callableStatement!=null){
			try {
				callableStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	return response;
}
}
