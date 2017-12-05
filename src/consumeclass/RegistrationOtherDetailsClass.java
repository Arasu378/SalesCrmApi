package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;

import model.LoginModel;
import model.RegistrationModel;
import response.LoginResponse;
import response.RegistrationResponse;
import utils.Constants;

public class RegistrationOtherDetailsClass {
public static RegistrationResponse insertOtherDetails(RegistrationModel model){
	RegistrationResponse response=new RegistrationResponse();
	String companyName=model.getCompanyName();
	int industryTypeId=model.getIndustryTypeId();
	int registrationId=model.getRegistrationId();
	int userProfileId=model.getUserProfileId();
	String timeZone=model.getTimeZone();
	int localeId=model.getUserLocaleId();
	int languageId=model.getLanguageId();
	int currencyId=model.getCurrencyId();
	String companyCode=model.getCompanyCode();
	String email=model.getEmailAddress();
	String password=model.getUserPassword();
	
	String value=updateRegistrationTable(companyName,industryTypeId,registrationId);
	if(value!=null){
	//	String valueprofile=updateUserProfileTable(timeZone,localeId,languageId,currencyId,userProfileId);
	//	if(valueprofile!=null){
			String companyvalue=insertCompany(userProfileId,companyCode,companyName);
			if(companyvalue!=null){
				LoginModel model2=new LoginModel();
				model2.setUserEmail(email);
				model2.setPassword(password);

//				ArrayList<LoginModel> lsnew=new ArrayList<LoginModel>();
				LoginResponse loginResponse=(LoginClass.login(model2));
//				for (int i = 0; i < lsold.size(); i++){
//					lsnew.add(i, lsold.get(i));
//			    } 
				
			
				try{
				//	System.out.println("LoginList Size : "+lsold.size());

				}catch(Exception e){
					e.printStackTrace();
				}
				response.setLogin(loginResponse);
				response.setIsSuccess(true);
				response.setLoginModel(null);
				response.setMessage("Success");
				response.setRegistrationList(null);
				
			}else{
				response.setIsSuccess(false);
				response.setMessage("insertCompany is failed or value is null");
				response.setRegistrationList(null);
				response.setLoginModel(null);

			}
		//}
//		else{
//			response.setIsSuccess(false);
//			response.setMessage("updateUserProfileTable is failed or value is null");
//			response.setRegistrationList(null);
//		}
		
	}else{
		response.setIsSuccess(false);
		response.setMessage("Updateregistrationtable is failed or value is null");
		response.setRegistrationList(null);
		response.setLoginModel(null);

	}
	
	
	
	return response;
}

public static String updateRegistrationTable(String CompanyName,int IndustryTypeId,int RegistrationId){
	String finalresponse=null;
	 Connection connection=null;
		CallableStatement callstatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="{CALL `Update.Registration_OtherDetails`(?,?,?)}";
		System.out.println("Query : "+query);
		System.out.println("Other details : "+"CALL `Update.Registration_OtherDetails`("+CompanyName+","+IndustryTypeId+","+RegistrationId);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setString(1,CompanyName );
		callstatement.setInt(2, IndustryTypeId);
		callstatement.setInt(3, RegistrationId);
		int count = callstatement.executeUpdate();
		if(count>0){
			finalresponse="true";
		}else{
			finalresponse="false";
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
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
	return finalresponse;
}
public static String updateUserProfileTable(String TimeZone, int UserLocaleId, int LanguageId, int CurrencyId, int UserProfileId){
	String finalresponse=null;
	 Connection connection=null;
		CallableStatement callstatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="{CALL  `Update.Company_UserProfile`(?,?,?,?,?)};";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callstatement = connection.prepareCall(query);
			callstatement.setString(1,TimeZone );
			callstatement.setInt(2, UserLocaleId);
			callstatement.setInt(3, LanguageId);
			callstatement.setInt(4, CurrencyId);
			callstatement.setInt(5, UserProfileId);

			int count = callstatement.executeUpdate();
			if(count>0){
				finalresponse="true";
			}else{
				finalresponse="false";
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
	return finalresponse;
}
public static String insertCompany(int UserProfileId,String CompanyCode, String CompanyName ){
	String finalresponse=null;
	 Connection connection=null;
		CallableStatement callstatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="{CALL `UserSettings.Company_InsertCompany`(?,?,?)}";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callstatement = connection.prepareCall(query);
			callstatement.setInt(1,UserProfileId );
			callstatement.setString(2, CompanyCode);
			callstatement.setString(3, CompanyName);
			

			int count = callstatement.executeUpdate();
			if(count>0){
				finalresponse="true";
			}else{
				finalresponse="false";
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
	
	return finalresponse;
}
@SuppressWarnings("unused")
private static String generateToken(String userEmail,String password,int userProfileId){
	String finalvalue=userEmail+"|"+password+"|"+userProfileId;
	byte[] encodedBytes = Base64.encodeBase64(finalvalue.getBytes());
	return new String(encodedBytes);
}
}
