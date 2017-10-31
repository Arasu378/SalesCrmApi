package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dbconstants.OrganizationDBConstants;
import model.DealModel;
import model.OrganizationModel;
import model.PersonModel;
import response.DealResponse;
import utils.Constants;

public class InsertDealsClass {
public static DealResponse insertDeal(DealModel model){
	
	DealResponse response=new DealResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	
	try{
		String query="{CALL `Company.Deal_InsertDeal` (?,?,?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		String title=model.getTitle();
		callableStatement.setString(1, title);
		int stageId=model.getStageId();
		callableStatement.setInt(2, stageId);
		int pipeLineId=model.getPipeLineId();
		callableStatement.setInt(3, pipeLineId);
		int userProfileId=model.getUserProfileId();
		callableStatement.setInt(4, userProfileId);
		int personId=model.getPersonId();
		callableStatement.setInt(5, personId);
		int organizationId=model.getOrganizationId();
		callableStatement.setInt(6, organizationId);
		boolean active=model.getActive();
		callableStatement.setBoolean(7, active);
		String ownerName=model.getOwnerName();
		callableStatement.setString(8, ownerName);
		
		int count=callableStatement.executeUpdate();
		if(count>0){
			response=GetDealByUserProfileIdClass.getDealByUserProfileId(userProfileId);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Deals not inserted");
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
			try{
				callableStatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	return response;
}
}
