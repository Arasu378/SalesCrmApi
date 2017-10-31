package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.OrganizationModel;
import response.OrganizationResponse;
import utils.Constants;

public class DeleteOrganizationByOrganizationIdClass {
	public static OrganizationResponse deleteOrganization(OrganizationModel model){
		OrganizationResponse response=new OrganizationResponse();
		Connection connection=null;
		CallableStatement callableStatement=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			String query="{CALL `Company.Organization_DeleteOrganizationByOrganizationId`(?)}";
			System.out.println("Query : "+query);
			int organizationId=model.getOrganizationId();
			int userProfileId=model.getOwnersUserProfileId();
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callableStatement=connection.prepareCall(query);
			callableStatement.setInt(1, organizationId);
			int count = callableStatement.executeUpdate();
			if(count>0){
				response=(GetOrganizationByUserProfileIdClass.getOrganizationByUserProfileId(userProfileId));
			}else{
				response.setIsSuccess(false);
				response.setMessage("Organization is not deleted");
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
					callableStatement.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return response;
	}

}
