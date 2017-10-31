package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.ProfilePictureModel;
import response.ProfilePictureResponse;
import utils.Constants;

public class DeleteProfilePictureClass {
public static ProfilePictureResponse deleteProfilePicture(ProfilePictureModel model){
	ProfilePictureResponse response=new ProfilePictureResponse();
	Connection connection=null;
	 java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int pictureid=model.getProfilePictureId();
			String query="CALL `UserSettings.ProfilePicture_DeleteProfilePicture`("+pictureid+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	           PreparedStatement stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           if(i>0){
	        	   response.setProfilePicture(null);
	        	   response.setIsSuccess(true);
	        	   response.setMessage("Successfully deleted ");
	           }else{
	        	   response.setProfilePicture(null);
	        	   response.setIsSuccess(false);
	        	   response.setMessage("Not deleted or picture id does not exist ");
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
