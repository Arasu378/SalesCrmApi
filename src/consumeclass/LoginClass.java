package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;

import dbconstants.LoginDBConstants;
import dbconstants.UserInterfaceDBConstants;
import model.LoginModel;
import model.UserInterfaceModel;
import response.LoginResponse;
import utils.Constants;

public class LoginClass {
	private static ArrayList<LoginModel>loginList=new ArrayList<LoginModel>();
	public static ArrayList<LoginModel> loginTest(LoginModel model){
		LoginResponse response=new LoginResponse();
		  ArrayList<LoginModel>loginListnew=new ArrayList<LoginModel>();

		  loginListnew.clear();
		 Connection connection=null;
		 java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	try{
			String userEmail=model.getUserEmail();
			userEmail="'"+userEmail+"'";
			String password=model.getPassword();
			byte[] encodedBytes = Base64.encodeBase64(password.getBytes());
			System.out.println("encodedBytes " + new String(encodedBytes));
			String new_encryptedpassword=new String (encodedBytes);
			new_encryptedpassword="'"+new_encryptedpassword+"'";
			String CompCode=getCompanyCode(userEmail,new_encryptedpassword);
			if(CompCode!=null){
				int profileid=getUserProfileId(CompCode);
				if(profileid!=0){
					String query="CALL `Company.usp_UserLogin`("+profileid+");";
					System.out.println("Query : "+query);
					connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
					st=connection.createStatement();
					   ResultSet rs=st.executeQuery(query);
					   
					   try{
						   while(rs.next()){
							   
							   LoginModel loModel=new LoginModel();
								  String companyCode=rs.getString(LoginDBConstants.COMPANY_CODE);
								 
								  if(companyCode==null){
									  companyCode="";
								  }
								  String companyName=rs.getString(LoginDBConstants.COMPANY_NAME);
								  if(companyName==null){
									  companyName="";
								  }
								  int connectionId=rs.getInt(LoginDBConstants.CONNECTION_ID);
								  boolean isConnectedToMailChimpAccount=rs.getBoolean(LoginDBConstants.IS_CONNECTED_TO_MAIL_CHIMP_ACCOUNT);
								  String mailChimpAccountEmail=rs.getString(LoginDBConstants.MAIL_CHIMP_ACCOUNT_EMAIL);
								  if(mailChimpAccountEmail==null){
									  mailChimpAccountEmail="";
								  }
								  int emailIntegrationId=rs.getInt(LoginDBConstants.EMAIL_INTEGRATION_ID);
								  String alternativeEmailAddress=rs.getString(LoginDBConstants.ALTERNATIVE_EMAIL_ADDRESS);
								  if(alternativeEmailAddress==null){
									  alternativeEmailAddress="";
								  }
								  boolean isMyLinkedEmailsShared=rs.getBoolean(LoginDBConstants.IS_MY_LINKED_EMAIL_SHARED);
								  boolean isMyEmailConversationsPrivate=rs.getBoolean(LoginDBConstants.IS_MY_EMAIL_CONVERSATION_PRIVATE);
								  boolean isLinkMyEmailManually=rs.getBoolean(LoginDBConstants.IS_MY_LINK_MY_EMAIL_MANUALLY);
								  boolean isEmailLinkWithDeals=rs.getBoolean(LoginDBConstants.IS_EMAIL_LINK_WITH_DEALS);
								  int contactId=rs.getInt(LoginDBConstants.CONTACT_ID);
								  boolean isConnectedToGoogleAccount=rs.getBoolean(LoginDBConstants.IS_CONNECTED_TO_GOOGLE_ACCOUNT);
								  String googleAccountEmail=rs.getString(LoginDBConstants.GOOGLE_ACCOUNT_EMAIL);
								  if(googleAccountEmail==null){
									  googleAccountEmail="";
								  }
								  int driveId=rs.getInt(LoginDBConstants.DRIVE_ID);
								  int profilePictureId=rs.getInt(LoginDBConstants.PROFILE_PICTURE_ID);
								  int attachmentId=rs.getInt(LoginDBConstants.ATTACHMENT_ID);
								  int reminderEmailId=rs.getInt(LoginDBConstants.REMINDER_EMAIL_ID);
								  String reminderTypeId=rs.getString(LoginDBConstants.REMINDER_TYPE_ID);
								  String reminderTimeId=rs.getString(LoginDBConstants.REMINDER_TIME_ID);
								  int userProfileId=rs.getInt(LoginDBConstants.USER_PROFILE_ID);
								  int companyId=rs.getInt(LoginDBConstants.COMPANY_ID);

							   
							  int userInterfaceId=rs.getInt(LoginDBConstants.USER_INTERFACE_ID);
							  boolean isDeal=rs.getBoolean(LoginDBConstants.IS_DEAL);
							  boolean isPerson=rs.getBoolean(LoginDBConstants.IS_PERSON);
							  boolean isOrganization=rs.getBoolean(LoginDBConstants.IS_ORGANIZATION);
							  loModel.setUserProfileId(userProfileId);
							  loModel.setCompanyId(companyId);
							  loModel.setCompanyCode(companyCode);
							  loModel.setCompanyName(companyName);
							  loModel.setConnectionId(connectionId);
							  loModel.setIsConnectedToMailChimpAccount(isConnectedToMailChimpAccount);
							  loModel.setMailChimpAccountEmail(mailChimpAccountEmail);
							  loModel.setEmailIntegrationId(emailIntegrationId);
							  loModel.setAlternativeEmailAddress(alternativeEmailAddress);
							  loModel.setIsMyLinkedEmailsShared(isMyLinkedEmailsShared);
							  loModel.setIsMyEmailConversationsPrivate(isMyEmailConversationsPrivate);
							  loModel.setIsLinkMyEmailManually(isLinkMyEmailManually);
							  loModel.setIsEmailLinkWithDeals(isEmailLinkWithDeals);
							  loModel.setContactId(contactId);
							  loModel.setIsConnectedToGoogleAccount(isConnectedToGoogleAccount);
							  loModel.setGoogleAccountEmail(googleAccountEmail);
							  loModel.setDriveId(driveId);
							  loModel.setProfilePictureId(profilePictureId);
							  loModel.setAttachmentId(attachmentId);
							  loModel.setReminderEmailId(reminderEmailId);
							  loModel.setReminderTypeId(reminderTypeId);
							  loModel.setReminderTimeId(reminderTimeId);
							  loModel.setUserInterfaceId(userInterfaceId);
							  loModel.setIsDeal(isDeal);
							  loModel.setIsPerson(isPerson);
							  loModel.setIsOrganization(isOrganization);
								  
							  loginListnew.add(loModel);
						   } 
						  }catch(Exception e){
							  e.printStackTrace();
						  }
					  
				}else{
					response.setIsSuccess(false);
					response.setMessage("ProfileId is zero");
					response.setLoginModel(null);
					return loginListnew;

				}
			}else{
				response.setIsSuccess(false);
				response.setMessage("Company code is empty or invalid useremail and password");
				response.setLoginModel(null);
				return loginListnew;
			}
		
			   if(loginListnew!=null&&loginListnew.size()!=0){
				   response.setIsSuccess(true);
				   response.setMessage("");
				   response.setLoginModel(loginListnew);
			   }else{
				   response.setIsSuccess(false);
				   response.setMessage("login List is Empty or Null!");
				   response.setLoginModel(null);
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
	System.out.println("LoginClass Loginlist size : "+loginListnew.size());
		return loginListnew;
	}
public static LoginResponse login(LoginModel model){
	LoginResponse response=new LoginResponse();
	loginList.clear();
	 Connection connection=null;
	 java.sql.Statement st=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
try{
		String userEmail=model.getUserEmail();
		userEmail="'"+userEmail+"'";
		String password=model.getPassword();
		byte[] encodedBytes = Base64.encodeBase64(password.getBytes());
		System.out.println("encodedBytes " + new String(encodedBytes));
		String new_encryptedpassword=new String (encodedBytes);
		new_encryptedpassword="'"+new_encryptedpassword+"'";
		String CompCode=getCompanyCode(userEmail,new_encryptedpassword);
		if(CompCode!=null){
			int profileid=getUserProfileId(CompCode);
			if(profileid!=0){
				String query="CALL `Company.usp_UserLogin`("+profileid+");";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				st=connection.createStatement();
				   ResultSet rs=st.executeQuery(query);
				   
				   try{
					   while(rs.next()){
						   
						   LoginModel loModel=new LoginModel();
							  String companyCode=rs.getString(LoginDBConstants.COMPANY_CODE);
							 
							  if(companyCode==null){
								  companyCode="";
							  }
							  String companyName=rs.getString(LoginDBConstants.COMPANY_NAME);
							  if(companyName==null){
								  companyName="";
							  }
							  int connectionId=rs.getInt(LoginDBConstants.CONNECTION_ID);
							  boolean isConnectedToMailChimpAccount=rs.getBoolean(LoginDBConstants.IS_CONNECTED_TO_MAIL_CHIMP_ACCOUNT);
							  String mailChimpAccountEmail=rs.getString(LoginDBConstants.MAIL_CHIMP_ACCOUNT_EMAIL);
							  if(mailChimpAccountEmail==null){
								  mailChimpAccountEmail="";
							  }
							  int emailIntegrationId=rs.getInt(LoginDBConstants.EMAIL_INTEGRATION_ID);
							  String alternativeEmailAddress=rs.getString(LoginDBConstants.ALTERNATIVE_EMAIL_ADDRESS);
							  if(alternativeEmailAddress==null){
								  alternativeEmailAddress="";
							  }
							  boolean isMyLinkedEmailsShared=rs.getBoolean(LoginDBConstants.IS_MY_LINKED_EMAIL_SHARED);
							  boolean isMyEmailConversationsPrivate=rs.getBoolean(LoginDBConstants.IS_MY_EMAIL_CONVERSATION_PRIVATE);
							  boolean isLinkMyEmailManually=rs.getBoolean(LoginDBConstants.IS_MY_LINK_MY_EMAIL_MANUALLY);
							  boolean isEmailLinkWithDeals=rs.getBoolean(LoginDBConstants.IS_EMAIL_LINK_WITH_DEALS);
							  int contactId=rs.getInt(LoginDBConstants.CONTACT_ID);
							  boolean isConnectedToGoogleAccount=rs.getBoolean(LoginDBConstants.IS_CONNECTED_TO_GOOGLE_ACCOUNT);
							  String googleAccountEmail=rs.getString(LoginDBConstants.GOOGLE_ACCOUNT_EMAIL);
							  if(googleAccountEmail==null){
								  googleAccountEmail="";
							  }
							  int driveId=rs.getInt(LoginDBConstants.DRIVE_ID);
							  int profilePictureId=rs.getInt(LoginDBConstants.PROFILE_PICTURE_ID);
							  int attachmentId=rs.getInt(LoginDBConstants.ATTACHMENT_ID);
							  int reminderEmailId=rs.getInt(LoginDBConstants.REMINDER_EMAIL_ID);
							  String reminderTypeId=rs.getString(LoginDBConstants.REMINDER_TYPE_ID);
							  String reminderTimeId=rs.getString(LoginDBConstants.REMINDER_TIME_ID);
							  int userProfileId=rs.getInt(LoginDBConstants.USER_PROFILE_ID);
							  int companyId=rs.getInt(LoginDBConstants.COMPANY_ID);

						   
						  int userInterfaceId=rs.getInt(LoginDBConstants.USER_INTERFACE_ID);
						  boolean isDeal=rs.getBoolean(LoginDBConstants.IS_DEAL);
						  boolean isPerson=rs.getBoolean(LoginDBConstants.IS_PERSON);
						  boolean isOrganization=rs.getBoolean(LoginDBConstants.IS_ORGANIZATION);
						  loModel.setUserProfileId(userProfileId);
						  loModel.setCompanyId(companyId);
						  loModel.setCompanyCode(companyCode);
						  loModel.setCompanyName(companyName);
						  loModel.setConnectionId(connectionId);
						  loModel.setIsConnectedToMailChimpAccount(isConnectedToMailChimpAccount);
						  loModel.setMailChimpAccountEmail(mailChimpAccountEmail);
						  loModel.setEmailIntegrationId(emailIntegrationId);
						  loModel.setAlternativeEmailAddress(alternativeEmailAddress);
						  loModel.setIsMyLinkedEmailsShared(isMyLinkedEmailsShared);
						  loModel.setIsMyEmailConversationsPrivate(isMyEmailConversationsPrivate);
						  loModel.setIsLinkMyEmailManually(isLinkMyEmailManually);
						  loModel.setIsEmailLinkWithDeals(isEmailLinkWithDeals);
						  loModel.setContactId(contactId);
						  loModel.setIsConnectedToGoogleAccount(isConnectedToGoogleAccount);
						  loModel.setGoogleAccountEmail(googleAccountEmail);
						  loModel.setDriveId(driveId);
						  loModel.setProfilePictureId(profilePictureId);
						  loModel.setAttachmentId(attachmentId);
						  loModel.setReminderEmailId(reminderEmailId);
						  loModel.setReminderTypeId(reminderTypeId);
						  loModel.setReminderTimeId(reminderTimeId);
						  loModel.setUserInterfaceId(userInterfaceId);
						  loModel.setIsDeal(isDeal);
						  loModel.setIsPerson(isPerson);
						  loModel.setIsOrganization(isOrganization);
							  
						  loginList.add(loModel);
					   } 
					  }catch(Exception e){
						  e.printStackTrace();
					  }
				  
			}else{
				response.setIsSuccess(false);
				response.setMessage("ProfileId is zero");
				response.setLoginModel(null);
				return response;

			}
		}else{
			response.setIsSuccess(false);
			response.setMessage("Company code is empty or invalid useremail and password");
			response.setLoginModel(null);
			return response;
		}
	
		   if(loginList!=null&&loginList.size()!=0){
			   response.setIsSuccess(true);
			   response.setMessage("");
			   response.setLoginModel(loginList);
		   }else{
			   response.setIsSuccess(false);
			   response.setMessage("login List is Empty or Null!");
			   response.setLoginModel(null);
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
@SuppressWarnings("unused")
private static String getCompanyCode(String email,String password) throws SQLException{
	String finalvalue=null;
	 Connection connection=null;
	 java.sql.Statement st=null;
	String query="CALL `GetCompanyCode_Login`("+email+","+password+");";
	System.out.println("Query : "+query);
	connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	st=connection.createStatement();
	   ResultSet rs=st.executeQuery(query);
	   
	   try{
		   while(rs.next()){
			   String CompanyCode=rs.getString(LoginDBConstants.COMPANY_CODE);
			   finalvalue=CompanyCode;
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
	
	return finalvalue;
}
@SuppressWarnings("unused")
private static int getUserProfileId(String CCode) throws SQLException{
	int  finalvalue=0;
	 Connection connection=null;
	 java.sql.Statement st=null;
	 CCode="'"+CCode+"'";
	 String query="CALL `GetUserProfileId_Login`("+CCode+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   
		   try{
			   while(rs.next()){
				   int UserProfileId=rs.getInt(LoginDBConstants.USER_PROFILE_ID);
				   finalvalue=UserProfileId;
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
	return finalvalue;
}

}
