package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.EmailIntegrationModel;
import response.EmailIntegrationResponse;
import utils.Constants;

public class DeleteEmailintegraionClass {
public static EmailIntegrationResponse deleteEmailIntegration(EmailIntegrationModel model){
	EmailIntegrationResponse response=new EmailIntegrationResponse();
	Connection connection=null;
	 java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int emailIntegrationId=model.getEmailIntegrationId();
			String query="CALL `UserSettings.EmailIntegration_DeleteEmailIntegration`("+emailIntegrationId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	           PreparedStatement stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           if(i>0){
	        	   response.setEmailIntegrationList(null);
	        	   response.setIsSuccess(true);
	        	   response.setMessage("Successfully deleted ");
	           }else{
	        	   response.setEmailIntegrationList(null);
	        	   response.setIsSuccess(false);
	        	   response.setMessage("Not deleted or email integration id does not exist");
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
