package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.ActivityTypeModel;
import response.ActivityTypeResponse;
import utils.Constants;

public class InsertActivityTypePipeDriveClass {
	public static ActivityTypeResponse insertActivityType(ActivityTypeModel model){
		ActivityTypeResponse response=new ActivityTypeResponse();
		Connection connection=null;
		CallableStatement callableStatement=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			String query="{CALL ()}";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callableStatement=connection.prepareCall(query);
			int userProfileId=model.getUserProfileId();
			
			int count=callableStatement.executeUpdate();
			if(count>0){
				response=GetActivityTypePipeDriveByUserProfielIdClass.getActivityTypeByUserProfileId(userProfileId);
			}else{
				response.setIsSuccess(false);
				response.setMessage("Activity type is not inserted");
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
