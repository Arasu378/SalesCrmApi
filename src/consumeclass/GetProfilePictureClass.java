package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconstants.ProfilePictureDBConstants;
import model.ProfilePictureModel;
import response.ProfilePictureResponse;
import utils.Constants;

public class GetProfilePictureClass {
	private static ArrayList<ProfilePictureModel>picArrayList=new ArrayList<ProfilePictureModel>();
public static ProfilePictureResponse getProfilePicture(int ProfilePictureId){
	ProfilePictureResponse response=new ProfilePictureResponse();
		picArrayList.clear();
		 Connection connection=null;
		 java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			
			String query="CALL `UserSettings.ProfilePicture_GetProfilePicturebyPictureId`("+ProfilePictureId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   
			   while(rs.next()){
				   ProfilePictureModel proModel=new ProfilePictureModel();
				  int profilePictureId=rs.getInt(ProfilePictureDBConstants.PROFILE_PICTURE_ID);
				  int userProfileId=rs.getInt(ProfilePictureDBConstants.USER_PROFILE_ID);
				  int attachmentId=rs.getInt(ProfilePictureDBConstants.ATTACHMENT_ID);
				  proModel.setProfilePictureId(profilePictureId);
				  proModel.setUserProfileId(userProfileId);
				  proModel.setAttachmentId(attachmentId);
				  picArrayList.add(proModel);
			   }
			   if(picArrayList!=null&&picArrayList.size()!=0){
				   response.setIsSuccess(true);
				   response.setMessage("");
				   response.setProfilePicture(picArrayList);
			   }else{
				   response.setIsSuccess(false);
				   response.setMessage("ProfilePictureList is Empty or Null!");
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
