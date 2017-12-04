package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;

import dbconstants.LoginDBConstants;
import dbconstants.RegistrationDBConstants;
import model.RegistrationModel;
import response.RegistrationResponse;
import utils.Constants;

public class RegistrationClass {
	public static int regId=0;
	public static ArrayList<RegistrationModel>registrationList=new ArrayList<RegistrationModel>();
public static RegistrationResponse registration(RegistrationModel model){
	RegistrationResponse response=new RegistrationResponse();
	CallableStatement callstatement=null;
	 java.sql.Statement st=null;

	Connection connection=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String email=model.getEmailAddress();
		email="'"+email+"'";
		String password=model.getUserPassword();
		byte[] encodedBytes = Base64.encodeBase64(password.getBytes());
		System.out.println("encodedBytes " + new String(encodedBytes));
		String new_encryptedpassword=new String (encodedBytes);
		new_encryptedpassword="'"+new_encryptedpassword+"'";
	String companyCode=RegisterEmail(email,new_encryptedpassword);
	String cCode=companyCode;
	System.out.println("RegistrationId : "+regId);
	if(companyCode!=null){
		companyCode="'"+companyCode+"'";
		String query="CALL `Registration_UserProfile`("+companyCode+");";
		System.out.println("Query: "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	//	callstatement = connection.prepareCall(query);
	///	callstatement.setString(1, companyCode);
	//	int count = callstatement.executeUpdate();
		
		st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   int proid=0;
		   while(rs.next()){
				 proid=rs.getInt(RegistrationDBConstants.LAST_INSERT_ID);
				 registrationList.clear();
					RegistrationModel mod=new RegistrationModel();
					mod.setRegistrationId(regId);
					mod.setCompanyCode(cCode);
					mod.setUserProfileId(proid);
					mod.setEmailAddress(model.getEmailAddress());
					registrationList.add(mod);
		   }
		  
		if(registrationList!=null && registrationList.size()!=0){
			response.setIsSuccess(true);
			response.setMessage("Registration Successfull");
			response.setLoginModel(null);
			response.setLoginModel(null);
			
		
			response.setRegistrationList(registrationList);
		}else{
			response.setIsSuccess(false);
			response.setLoginModel(null);
			response.setMessage("Registration is not successfull or registration list is empty");
			response.setRegistrationList(null);
		}

		
	}else{
		response.setIsSuccess(false);
		response.setMessage("company code is empty: or Email is Already registered");
		response.setRegistrationList(null);
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
@SuppressWarnings("unused")
private static String RegisterEmail(String email,String password){
	String finalvalue=null;

	Connection connection=null;
	 java.sql.Statement st=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		
		String query="CALL  `Company.usp_RegisterEmail`("+email+","+password+")";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   while(rs.next()){
			   String companyCode=rs.getString(RegistrationDBConstants.COMPANY_CODE);
			   int registrationId=rs.getInt(RegistrationDBConstants.REGISTRATION_ID);
			 String emailAddress=rs.getString(RegistrationDBConstants.EMAIL_ADDRESS);
			 if(emailAddress==null){
				 emailAddress="";
			 }
			 String userName=rs.getString(RegistrationDBConstants.USER_NAME);
			 if(userName==null){
				 userName="";
			 }
			   regId=registrationId;
			   finalvalue=companyCode;
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
