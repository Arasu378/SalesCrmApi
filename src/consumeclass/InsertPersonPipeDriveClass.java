package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dbconstants.OrganizationDBConstants;
import model.PersonEmailModel;
import model.PersonModel;
import model.PersonPhoneModel;
import response.PersonResponse;
import utils.Constants;

public class InsertPersonPipeDriveClass {
public static PersonResponse insertPerson(PersonModel model){
	PersonResponse response=new PersonResponse();
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	int personId=insertPersonPipeDrive(model);
	if(personId!=0){
					ArrayList<PersonPhoneModel>personPhoneList=model.getPersonPhoneList();
					int personPhoneValue=insertPersonPhone(personId, personPhoneList);
				
				if(personPhoneValue!=0){
					ArrayList<PersonEmailModel>personEmailList=model.getPersonEmailList();
					int personEmailValue=insertPersonEmail(personId, personEmailList);
					if(personEmailValue!=0){
						int UserProfileId=model.getUserProfileId();
						response=GetPersonByUserProfileIdClass.getPersonByUserProfileId(UserProfileId);
					}else{
						response.setIsSuccess(false);
						response.setMessage("PersonEmail is not inserted");
						response.setPersonList(null);
					}
				}else{
					response.setIsSuccess(false);
					response.setMessage("PersonPhone is not inserted");
					response.setPersonList(null);
				}
	}else{
		response.setIsSuccess(false);
		response.setMessage("Person is not inserted");
		response.setPersonList(null);
	}
	
	return response;
}
private static int insertPersonPipeDrive(PersonModel model){
	int finalvalue=0;
	Connection connection=null;
	Statement st=null;
	
	String userName=model.getUserName();
	userName="'"+userName+"'";
	int userProfileId=model.getUserProfileId();
	String companyCode=model.getCompanyCode();
	companyCode="'"+companyCode+"'";
	int orgId=model.getOrgId();
	boolean activeFlag=model.getActiveFlag();
	int visibltTo=model.getVisibleTo();
	String orgName=model.getOrgName();
	orgName="'"+orgName+"'";
	String ownerName=model.getOwnerName();
	ownerName="'"+ownerName+"'";
	try{
		String query="CALL `UserSettings.Person_InsertPipePerson`("+userName+","+userProfileId+","+companyCode+","+orgId+","+activeFlag+","+visibltTo+","+orgName+","+ownerName+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()){
			finalvalue=rs.getInt(OrganizationDBConstants.LAST_INSERT_ID);

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
private static int insertPersonPhone(int personId,ArrayList<PersonPhoneModel>phoneList){
	int finalvalue=0;
	Connection connection=null;
	Statement st=null;
	try{
		
		if(phoneList!=null&&phoneList.size()!=0){
			for(int i=0; i<phoneList.size();i++){
				String label=phoneList.get(i).getLabel();
				label="'"+label+"'";
				String value=phoneList.get(i).getValue();
				value="'"+value+"'";
				boolean primary=phoneList.get(i).getPrimary();
				
				String query ="CALL  `UserSettings.PersonPhone_InsertPipeDrivePersonPhone`("+label+","+value+","+primary+","+personId+")";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				st=connection.createStatement();
				ResultSet rs=st.executeQuery(query);
				while(rs.next()){
					finalvalue=rs.getInt(OrganizationDBConstants.LAST_INSERT_ID);

				}
			}
			
		}else{
			 finalvalue=0;
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
private static int insertPersonEmail(int personId,ArrayList<PersonEmailModel>personEmailList){
	int finalvalue=0;
	Connection connection=null;
	Statement st=null;
	try{
		if(personEmailList!=null &&personEmailList.size()!=0){
			for(int i=0;i<personEmailList.size();i++){
				 String label=personEmailList.get(i).getLabel();
				 label="'"+label+"'";
				 String value=personEmailList.get(i).getValue();
				 value="'"+value+"'";
				 boolean primary=personEmailList.get(i).getPrimary();
				 String query="CALL `UserSettings.PersonEmail_InsertPersonEmail` ("+label+","+value+","+primary+","+personId+")";
				 System.out.println("Query : "+query);
				 connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				 st=connection.createStatement();
				 ResultSet rs=st.executeQuery(query);
				 while(rs.next()){
					 finalvalue=rs.getInt(OrganizationDBConstants.LAST_INSERT_ID);
				 }
						 
			}
		}else{
			return 0;
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
