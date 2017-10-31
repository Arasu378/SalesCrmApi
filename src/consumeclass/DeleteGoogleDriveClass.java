package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.GoogleDriveModel;
import response.GoogleDriveResponse;
import utils.Constants;

public class DeleteGoogleDriveClass {
public static GoogleDriveResponse deleteGoogleDrive(GoogleDriveModel model){
	GoogleDriveResponse response=new GoogleDriveResponse();
	Connection connection=null;
	 java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int driveId=model.getDriveId();
			String query="CALL `UserSettings.GoogleDrive_DeleteGoogleDrive`("+driveId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	           PreparedStatement stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           if(i>0){
	        	   response.setGoogleDriveList(null);
	        	   response.setIsSuccess(true);
	        	   response.setMessage("Successfully deleted ");
	           }else{
	        	   response.setGoogleDriveList(null);
	        	   response.setIsSuccess(false);
	        	   response.setMessage("Not deleted or drive id does not exist");
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
