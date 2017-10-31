package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.GoogleContactsModel;
import response.GoogleContactsResponse;
import utils.Constants;

public class DeleteGoogleContactsClass {
public static GoogleContactsResponse deleteGoogleContacts(GoogleContactsModel model){
	GoogleContactsResponse response=new GoogleContactsResponse();
	Connection connection=null;
	 java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int contactId=model.getContactId();
			String query="CALL `UserSettings.GoogleContacts_DeleteGoogleContacts`("+contactId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	           PreparedStatement stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           if(i>0){
	        	   response.setGoogleContactList(null);
	        	   response.setIsSuccess(true);
	        	   response.setMessage("Successfully deleted ");
	           }else{
	        	   response.setGoogleContactList(null);
	        	   response.setIsSuccess(false);
	        	   response.setMessage("Not deleted  or contact id does not exist");
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
				try {
					st.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	return response;
}
}
