package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.EmailIntegrationModel;
import response.EmailIntegrationResponse;
import utils.Constants;

public class InsertEmailIntegrationClass {
public static EmailIntegrationResponse insertEmailIntegration(EmailIntegrationModel model){
	EmailIntegrationResponse response=new EmailIntegrationResponse();
	Connection connection=null;
		CallableStatement callstatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		int profileId=model.getUserProfileId();
		String alternativeEmailAddress=model.getAlternativeEmailAddress();
		boolean isLinkedEmailShared=model.getIsMyLinkedEmailsShared();
		boolean isMyEmailConversationsPrivate=model.getIsMyEmailConversationsPrivate();
		boolean isMyLinkEmailManually=model.getIsLinkMyEmailManually();
		boolean isEmailLinkWithDeals=model.getIsEmailLinkWithDeals();
		boolean isActive=model.getIsActive();
	
		String query="{CALL `UserSettings.EmailIntegration_InsertEmail`(?,?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setInt(1,profileId );
		callstatement.setString(2, alternativeEmailAddress);
		callstatement.setBoolean(3, isLinkedEmailShared);
		callstatement.setBoolean(4, isMyEmailConversationsPrivate);
		callstatement.setBoolean(5, isMyLinkEmailManually);
		callstatement.setBoolean(6, isEmailLinkWithDeals);
		callstatement.setBoolean(7, isActive);


		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("Email inserted Successfully");
			response.setEmailIntegrationList(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Email is not inserted");
			response.setEmailIntegrationList(null);
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
