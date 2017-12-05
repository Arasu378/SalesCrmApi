package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			System.out.println("Encrypted Password : "+new_encryptedpassword);
			new_encryptedpassword="'"+new_encryptedpassword+"'";
			System.out.println("Encrypted Password with quote : "+new_encryptedpassword);
			String CompCode=getCompanyCode(userEmail,new_encryptedpassword);
			if(CompCode!=null){
				int  UserProfileId=getUserProfileId(CompCode);
				if(UserProfileId!=0){
					LoginResponse loginResponse=getLoginView(UserProfileId,null);
					response=loginResponse;
				}else{
					response.setIsSuccess(false);
					response.setMessage("UserProfileId is zero");
					response.setLoginModel(null);
				}
			}else{
				response.setIsSuccess(false);
				response.setMessage("Company code is empty or invalid useremail and password");
				response.setLoginModel(null);
				return loginListnew;
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
		System.out.println("Encrypted Password : "+new_encryptedpassword);
		new_encryptedpassword="'"+new_encryptedpassword+"'";
		System.out.println("Encrypted Password with quote : "+new_encryptedpassword);
		String CompCode=getCompanyCode(userEmail,new_encryptedpassword);
		if(CompCode!=null){
			int  UserProfileId=getUserProfileId(CompCode);
			
			if(UserProfileId!=0){
				String tokenAuthentication=InsertTokenClass.getTokenByUserProfileId(UserProfileId);
					LoginResponse loginResponse=getLoginView(UserProfileId,tokenAuthentication);
					response=loginResponse;
				
				
			}else{
				response.setIsSuccess(false);
				response.setMessage("UserProfileId is zero");
				response.setLoginModel(null);
			}
			
		}else{
			response.setIsSuccess(false);
			response.setMessage("Company code is empty or invalid useremail and password");
			response.setLoginModel(null);
			return response;
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
private static int  getUserProfileId(String CCode) throws SQLException{
	 Connection connection=null;
	 java.sql.Statement st=null;
	 int finalvalue=0;
	 CCode="'"+CCode+"'";
	 String query="CALL `GetUserProfileId_Login`("+CCode+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   
		   try{
			   while(rs.next()){
				   int userProfileId=rs.getInt(LoginDBConstants.USER_PROFILE_ID);
				   finalvalue=userProfileId;
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
private static LoginResponse getLoginView(int UserProfileId,String token){
	LoginResponse response=new LoginResponse();
	ArrayList<LoginModel>loginList=new ArrayList<LoginModel>();
	loginList.clear();
	Connection connection=null;
	Statement st=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="CALL `User.Login_View`("+UserProfileId+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()){
			LoginModel model=new LoginModel();
			String companyCode=rs.getString(LoginDBConstants.COMPANY_CODE);
			if(companyCode==null){
				companyCode="";
			}
			model.setCompanyCode(companyCode);
			int registrationId=rs.getInt(LoginDBConstants.REGISTRATION_ID);
			model.setRegistrationId(registrationId);
			String emailAddress=rs.getString(LoginDBConstants.EMAIL_ADDRESS);
			if(emailAddress==null){
				emailAddress="";
			}
			model.setUserEmail(emailAddress);
			String userPassword=rs.getString(LoginDBConstants.USER_PASSWORD);
			if(userPassword==null){
				userPassword="";
			}
			model.setPassword(userPassword);
			String userName=rs.getString(LoginDBConstants.USER_NAME);
			if(userName==null){
				userName="";
			}
			if(token!=null){
				model.setToken(token);
			}else{
				model.setToken("");
			}
			model.setUserName(userName);
			String companyName=rs.getString(LoginDBConstants.COMPANY_NAME);
			if(companyName==null){
				companyName="";
			}
			model.setCompanyName(companyName);
			int industryTypeId=rs.getInt(LoginDBConstants.INDUSTRY_TYPE_ID);
			model.setIndustryTypeId(industryTypeId);
			String lastLogin=rs.getString(LoginDBConstants.LAST_LOGIN);
			if(lastLogin==null){
				lastLogin="";
			}
			model.setLastLogin(lastLogin);
			int userProfileId=rs.getInt(LoginDBConstants.USER_PROFILE_ID);
			model.setUserProfileId(userProfileId);
			String timeZone=rs.getString(LoginDBConstants.TIME_ZONE);
			if(timeZone==null){
				timeZone="";
			}
			model.setTimeZone(timeZone);
			int userLocaleId=rs.getInt(LoginDBConstants.USER_LOCALE_ID);
			model.setUserLocaleId(userLocaleId);
			int languageId=rs.getInt(LoginDBConstants.LANGUAGE_ID);
			model.setLanguageId(languageId);
			int currencyId=rs.getInt(LoginDBConstants.CURRENCY_ID);
			model.setCurrencyId(currencyId);
			boolean isActive=rs.getBoolean(LoginDBConstants.IS_ACTIVE);
			model.setIsActive(isActive);
			String createdDate=rs.getString(LoginDBConstants.CREATED_DATE);
			if(createdDate==null){
				createdDate="";
			}
			model.setCreatedDate(createdDate);
			String modifiedDate=rs.getString(LoginDBConstants.MODIFIED_DATE);
			if(modifiedDate==null){
				modifiedDate="";
			}
			model.setModifiedDate(modifiedDate);
			boolean hasPic=rs.getBoolean(LoginDBConstants.HAS_PIC);
			model.setHasPic(hasPic);
			loginList.add(model);
		}
		if(loginList!=null && loginList.size()!=0){
			response.setIsSuccess(true);
			response.setMessage("Success");
			response.setLoginModel(loginList);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Login list is empty or null");
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
	
}
