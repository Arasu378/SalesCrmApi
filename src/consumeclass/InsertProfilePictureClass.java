package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.ProfilePictureModel;
import response.ProfilePictureResponse;
import utils.Constants;

public class InsertProfilePictureClass {
public static ProfilePictureResponse insertProfilePicture(ProfilePictureModel model){
	ProfilePictureResponse response=new ProfilePictureResponse();
	Connection connection=null;
	CallableStatement callstatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="{CALL `UserSettings.ProfilePicture_InsertProfilePicture`(?,?)}";
		System.out.println("Query : "+query);
		int  profileId=model.getUserProfileId();
		int attachmentId=model.getAttachmentId();
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		System.out.println("UserProfileID : "+profileId+" / "+"AttachmentId : "+attachmentId);
		callstatement.setInt(1,profileId );
		callstatement.setInt(2,attachmentId );
		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("ProfilePicture inserted Successfully");
			response.setProfilePicture(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("ProfilePicture is not inserted");
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
