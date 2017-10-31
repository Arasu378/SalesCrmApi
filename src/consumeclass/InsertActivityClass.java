package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.ActivityModel;
import response.ActivityResponse;
import utils.Constants;

public class InsertActivityClass {
public static ActivityResponse insertActivity(ActivityModel model){
	ActivityResponse response=new ActivityResponse();
	
	Connection connection=null;
	CallableStatement callableStatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try {
		String query="{CALL `UserSettings.Activity_InsertAcitvity`(?,?,?,?,?) }";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		int companyId=model.getCompanyId();
		callableStatement.setInt(1,companyId);
		int userProfileId=model.getUserProfileId();
		callableStatement.setInt(2, userProfileId);
		String type=model.getType();
		callableStatement.setString(3,type);
		String subject=model.getSubject();
		callableStatement.setString(4,subject);
		int orgId=model.getOrgId();
		callableStatement.setInt(5,orgId);
		
		int count = callableStatement.executeUpdate();
		if(count>0){
			response=GetActivitiesByUserProfileIdClass.getActivitiesByUserProfileId(userProfileId);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Activity is not inserted");
			response.setActivityList(null);
		}
		
	} catch (Exception e) {
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
