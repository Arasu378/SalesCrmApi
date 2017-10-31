package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.PersonEmailModel;
import response.PersonEmailResponse;
import utils.Constants;
import dbconstants.PersonEmailDBConstants;

public class GetPersonEmailByPersonEmailIdClass {
	private static ArrayList<PersonEmailModel>personEmailList=new ArrayList<PersonEmailModel>();
	public static PersonEmailResponse getPersonEmailByPersonEmailId(int PersonEmailId){
		PersonEmailResponse response=new PersonEmailResponse();
		Connection connection =null;
		Statement st=null;
		personEmailList.clear();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			String query="CALL `UserSettings.PersonEmail_GetPersonEmailByPersonEmailId`("+PersonEmailId+")";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			st=connection.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
				PersonEmailModel model=new PersonEmailModel();
				int personEmailId=rs.getInt(PersonEmailDBConstants.PERSON_EMAIL_ID);
				model.setPersonEmailId(personEmailId);
				String label=rs.getString(PersonEmailDBConstants.LABEL);
				model.setLabel(label);
				String value=rs.getString(PersonEmailDBConstants.VALUE);
				model.setValue(value);
				boolean primary=rs.getBoolean(PersonEmailDBConstants.PRIMARY);
				model.setPrimary(primary);
				String createdDate=rs.getString(PersonEmailDBConstants.CREATED_DATE);
				model.setCreatedDate(createdDate);
				String modifiedDate=rs.getString(PersonEmailDBConstants.MODIFIED_DATE);
				model.setModifiedDate(modifiedDate);
				int personId=rs.getInt(PersonEmailDBConstants.PERSON_ID);
				model.setPersonId(personId);
				personEmailList.add(model);
			}
			if(personEmailList!=null && personEmailList.size()!=0){
				response.setIsSuccess(true);
				response.setMessage("");
				response.setPersonEmailList(personEmailList);
			}else{
				response.setIsSuccess(false);
				response.setMessage("person email list is empty or null");
				response.setPersonEmailList(null);
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
		return response;
	}

}
