package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.ProfilePictureModel;
import response.ProfilePictureResponse;
import utils.Constants;

public class UpdateProfilePictureClass {
public static ProfilePictureResponse updateProfilePicture(ProfilePictureModel model){
	ProfilePictureResponse response=new ProfilePictureResponse();
	 Connection connection=null;
		CallableStatement callstatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int pictureId=model.getProfilePictureId();
			int attachmentId=model.getAttachmentId();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 Date date = new Date();
			 System.out.println(dateFormat.format(date));
			 String ModifiedDate=dateFormat.format(date);
			String query="{CALL `UserSettings.ProfilePicture_UpdateProfilePicture`(?,?)}";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callstatement = connection.prepareCall(query);
			callstatement.setInt(1,pictureId );
			callstatement.setInt(2, attachmentId);
			int count = callstatement.executeUpdate();
			if(count>0){
				response.setIsSuccess(true);
				response.setMessage("ProfilePicture updated Successfully");
				response.setProfilePicture(null);
			}else{
				response.setIsSuccess(false);
				response.setMessage("ProfilePicture is not updated or picture id is not exist");
				response.setProfilePicture(null);
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
}
