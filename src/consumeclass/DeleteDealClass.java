package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.DealModel;
import response.DealResponse;
import utils.Constants;

public class DeleteDealClass {
public static DealResponse deleteDeal(DealModel model){
	DealResponse response=new DealResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="{CALL `Company.Deal_DeleteDeal`(?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		int userProfileId=model.getUserProfileId();
		int dealId=model.getDealId();
		callableStatement.setInt(1, dealId);
		int count=callableStatement.executeUpdate();
		if(count>0){
			response=GetDealByUserProfileIdClass.getDealByUserProfileId(userProfileId);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Deal deleted is failed");
			response.setDealList(null);
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
