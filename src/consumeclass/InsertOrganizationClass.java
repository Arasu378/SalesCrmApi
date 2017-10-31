package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.OrganizationModel;
import response.OrganizationResponse;
import utils.Constants;

public class InsertOrganizationClass {
public static OrganizationResponse insertOrganization(OrganizationModel model){
	OrganizationResponse response =new OrganizationResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="{CALL `Company.Organization_InsertOrganization`(?,?,?,?,?,?,?) }";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		String name=model.getName();
		String ownerName=model.getOwnerName();
		String address=model.getAddress();
		int visibleTo=model.getVisibleTo();
		boolean activeFlag=model.getActiveFlag();
		int userProfileId=model.getOwnersUserProfileId();
		String companyCode=model.getCompanyCode();
		callableStatement.setString(1, name);
		callableStatement.setInt(2, userProfileId);
		callableStatement.setString(3, companyCode);
		callableStatement.setString(4, ownerName);
		callableStatement.setString(5, address);
		callableStatement.setInt(6, visibleTo);
		callableStatement.setBoolean(7, activeFlag);
		
		
		int count = callableStatement.executeUpdate();
		if(count>0){
			response=GetOrganizationByUserProfileIdClass.getOrganizationByUserProfileId(userProfileId);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Organization  is not inserted");
			response.setOrganizationList(null);
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
		if(callableStatement!=null){
			try{
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	return response;
}
}
