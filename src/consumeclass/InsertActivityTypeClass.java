package consumeclass;

import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.ActivityTypeModel;
import response.ActivityTypeResponse;
import utils.Constants;

public class InsertActivityTypeClass {
public static ActivityTypeResponse  insertAcitivity(ActivityTypeModel model){
	ActivityTypeResponse response=new ActivityTypeResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="{CALL `UserSettings.ActivityType_InsertActivityType`(?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		int orderNr=model.getOrderNr();
		callableStatement.setInt(1, orderNr);
		String name=model.getName();
		callableStatement.setString(2, name);
		String keyString=model.getKeyString();
		callableStatement.setString(3, keyString);
		String iconKey=model.getIconKey();
		callableStatement.setString(4, iconKey);
		boolean activeFlag=model.getActiveFlag();
		callableStatement.setBoolean(5, activeFlag);
		boolean isCustomFlag=model.getIsCustomFlag();
		callableStatement.setBoolean(6, isCustomFlag);
		int count = callableStatement.executeUpdate();
		
		if(count>0){
			response=GetActivityTypeClass.getActivityType();
		}else{
			response.setIsSuccess(false);
			response.setMessage("Activity Type is not inserted");
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
