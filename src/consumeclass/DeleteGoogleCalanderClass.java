package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.GoogleCalanderModel;
import response.GoogleCalanderResponse;
import utils.Constants;

public class DeleteGoogleCalanderClass {
public static GoogleCalanderResponse deleteGoogleCalander(GoogleCalanderModel model){
	GoogleCalanderResponse response=new GoogleCalanderResponse();
	Connection connection=null;
	 java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int connectionId=model.getConnectionId();
			String query="CALL `UserSettings.GoogleCalendar_DeleteGoogleCalendar`("+connectionId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	           PreparedStatement stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           if(i>0){
	        	   response.setGoogleCalanderList(null);
	        	   response.setIsSuccess(true);
	        	   response.setMessage("Successfully deleted ");
	           }else{
	        	   response.setGoogleCalanderList(null);
	        	   response.setIsSuccess(false);
	        	   response.setMessage("Not deleted or connection id does not exist ");
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
