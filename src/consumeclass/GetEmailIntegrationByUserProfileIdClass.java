package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconstants.EmailIntegrationDBConstants;
import model.EmailIntegrationModel;
import response.EmailIntegrationResponse;
import utils.Constants;

public class GetEmailIntegrationByUserProfileIdClass {
	private static ArrayList<EmailIntegrationModel>emailIntegrationList=new ArrayList<EmailIntegrationModel>();
public static EmailIntegrationResponse getEmailIntegrationByUserProfileId(int UserProfileId){
EmailIntegrationResponse response=new EmailIntegrationResponse();
emailIntegrationList.clear();
Connection connection=null;
java.sql.Statement st=null;
try {
	Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e1) {
	e1.printStackTrace();
}
try{

	String query="CALL  `UserSettings.EmailIntegratin_GetEmailIntegrationByUserProfileId`("+UserProfileId+");";
	System.out.println("Query : "+query);
	connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	st=connection.createStatement();
	   ResultSet rs=st.executeQuery(query);
	   
	   while(rs.next()){
		   EmailIntegrationModel emModel=new EmailIntegrationModel();
		  int emailIntegrationId=rs.getInt(EmailIntegrationDBConstants.EMAIL_INTEGRATION_ID);
		  int userProfileId=rs.getInt(EmailIntegrationDBConstants.USER_PROFILE_ID);
		  String alternativeEmailAddress=rs.getString(EmailIntegrationDBConstants.ALTERNATIVE_EMAIL_ADDRESS);
		  if(alternativeEmailAddress==null){
			  alternativeEmailAddress="";
		  }
		  boolean isMyLinkedEmailsShared=rs.getBoolean(EmailIntegrationDBConstants.IS_MY_LINKED_EMAIL_SHARED);
		  boolean isMyEmailConversationsPrivate=rs.getBoolean(EmailIntegrationDBConstants.IS_MY_EMAIL_CONVERSATIONS_PRIVATE);
		  boolean isLinkMyEmailManually=rs.getBoolean(EmailIntegrationDBConstants.IS_LINK_MY_EMAIL_MANUALLY);
		  boolean isEmailLinkWithDeals=rs.getBoolean(EmailIntegrationDBConstants.IS_EMAIL_LINK_WITH_DEALS);
		  boolean isActive=rs.getBoolean(EmailIntegrationDBConstants.IS_ACTIVE);
		 
		  String createdDate=rs.getString(EmailIntegrationDBConstants.CREATED_DATE);
		  if(createdDate==null){
			  createdDate="";
		  }
		  String modifiedDate=rs.getString(EmailIntegrationDBConstants.MODIFIED_DATE);
		  if(modifiedDate==null){
			  modifiedDate="";
		  }
		  emModel.setEmailIntegrationId(emailIntegrationId);
		  emModel.setUserProfileId(userProfileId);
		  emModel.setAlternativeEmailAddress(alternativeEmailAddress);
		  emModel.setIsMyLinkedEmailsShared(isMyLinkedEmailsShared);
		  emModel.setIsMyEmailConversationsPrivate(isMyEmailConversationsPrivate);
		  emModel.setIsEmailLinkWithDeals(isEmailLinkWithDeals);
		  emModel.setIsLinkMyEmailManually(isLinkMyEmailManually);
		  emModel.setIsActive(isActive);
		  emModel.setCreatedDate(createdDate);
		  emModel.setModifiedDate(modifiedDate);
				  
		  
		  emailIntegrationList.add(emModel);
	   }
	   if(emailIntegrationList!=null&&emailIntegrationList.size()!=0){
		   response.setIsSuccess(true);
		   response.setMessage("");
		   response.setEmailIntegrationList(emailIntegrationList);
	   }else{
		   response.setIsSuccess(false);
		   response.setMessage("EmailIntegration List is Empty or Null!");
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
	if(st!=null){
		try{
			st.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
return response;
}
}
