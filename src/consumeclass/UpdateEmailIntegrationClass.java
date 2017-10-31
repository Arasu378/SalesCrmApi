package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.EmailIntegrationModel;
import response.EmailIntegrationResponse;
import utils.Constants;

public class UpdateEmailIntegrationClass {
public static EmailIntegrationResponse updateEmailIntegration(EmailIntegrationModel model){
	EmailIntegrationResponse response=new EmailIntegrationResponse();
	Connection connection=null;
	CallableStatement callstatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 int emailIntegrationId=model.getEmailIntegrationId();
		 int profileId=model.getUserProfileId();
		 String alternativeEmailAddress=model.getAlternativeEmailAddress();
		 boolean isMyLinkedEmailShared=model.getIsMyLinkedEmailsShared();
		 boolean isMyEmailConversationsPrivate=model.getIsMyEmailConversationsPrivate();
		 boolean isLinkMyEmailManually=model.getIsLinkMyEmailManually();
		 boolean isEmailLinkWithDeals=model.getIsEmailLinkWithDeals();
		 boolean isactive=model.getIsActive();
		 
		 System.out.println(dateFormat.format(date));
		 String ModifiedDate=dateFormat.format(date);
		String query="{CALL  `UserSettings.EmailIntegration_UpdateEmailIntegration`(?,?,?,?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setInt(1,emailIntegrationId );
		callstatement.setInt(2,profileId );
		callstatement.setString(3, alternativeEmailAddress);
		callstatement.setBoolean(4, isMyLinkedEmailShared);
		callstatement.setBoolean(5, isMyEmailConversationsPrivate);
		callstatement.setBoolean(6, isLinkMyEmailManually);
		callstatement.setBoolean(7, isEmailLinkWithDeals);
		callstatement.setBoolean(8, isactive);

		callstatement.setString(9, ModifiedDate);
		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("Email updated Successfully");
			response.setEmailIntegrationList(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Email is not updated or email integration id is not existed");
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
