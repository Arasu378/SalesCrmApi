package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dbconstants.PersonPhoneDBConstants;
import model.PersonPhoneModel;
import response.PersonPhoneResponse;
import response.PersonResponse;
import utils.Constants;

public class GetPersonPhoneByPersonIdClass {
	private static ArrayList<PersonPhoneModel>personPhoneList=new ArrayList<PersonPhoneModel>();
	public static PersonPhoneResponse getPersonPhone(int PersonId){
		PersonPhoneResponse response=new PersonPhoneResponse();
		Connection connection=null;
		Statement st=null;
		personPhoneList.clear();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			String query="CALL `UserSettings.PersonPhone_GetPersonPhoneByPersonId` ("+PersonId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			st=connection.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
				PersonPhoneModel model=new PersonPhoneModel();
				int personPhoneId=rs.getInt(PersonPhoneDBConstants.PERSON_PHONE_ID);
				model.setPersonPhoneId(personPhoneId);
				String label=rs.getString(PersonPhoneDBConstants.LABEL);
				if(label==null){
					label="";
				}
				model.setLabel(label);
				String value=rs.getString(PersonPhoneDBConstants.VALUE);
				if(value==null){
					value="";
				}
				model.setValue(value);
				boolean primary=rs.getBoolean(PersonPhoneDBConstants.PRIMARY);
				model.setPrimary(primary);
				String createdDate=rs.getString(PersonPhoneDBConstants.CREATED_DATE);
				if(createdDate==null){
					createdDate="";
				}
				model.setCreatedDate(createdDate);
				String modifiedDate=rs.getString(PersonPhoneDBConstants.MODIFIED_DATE);
				if(modifiedDate==null){
					modifiedDate="";
				}
				model.setModifiedDate(modifiedDate);
				int personId=rs.getInt(PersonPhoneDBConstants.PERSON_ID);
				model.setPersonId(personId);
				
				personPhoneList.add(model);
			}
			if(personPhoneList!=null && personPhoneList.size()!=0){
				response.setIsSuccess(true);
				response.setMessage("");
				response.setPersonPhoneList(personPhoneList);
			}else{
				response.setIsSuccess(false);
				response.setMessage("PersonPhone list is empty or null");
				response.setPersonPhoneList(null);
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
	public static ArrayList<PersonPhoneModel>getPersonPhoneList(int PersonId){
		Connection connection=null;
		Statement st=null;
		personPhoneList.clear();
		try{
			String query="CALL `UserSettings.PersonPhone_GetPersonPhoneByPersonId` ("+PersonId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			st=connection.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
				PersonPhoneModel model=new PersonPhoneModel();
				int personPhoneId=rs.getInt(PersonPhoneDBConstants.PERSON_PHONE_ID);
				model.setPersonPhoneId(personPhoneId);
				String label=rs.getString(PersonPhoneDBConstants.LABEL);
				if(label==null){
					label="";
				}
				model.setLabel(label);
				String value=rs.getString(PersonPhoneDBConstants.VALUE);
				if(value==null){
					value="";
				}
				model.setValue(value);
				boolean primary=rs.getBoolean(PersonPhoneDBConstants.PRIMARY);
				model.setPrimary(primary);
				String createdDate=rs.getString(PersonPhoneDBConstants.CREATED_DATE);
				if(createdDate==null){
					createdDate="";
				}
				model.setCreatedDate(createdDate);
				String modifiedDate=rs.getString(PersonPhoneDBConstants.MODIFIED_DATE);
				if(modifiedDate==null){
					modifiedDate="";
				}
				model.setModifiedDate(modifiedDate);
				int personId=rs.getInt(PersonPhoneDBConstants.PERSON_ID);
				model.setPersonId(personId);
				
				personPhoneList.add(model);
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
		return personPhoneList;
	}

}
