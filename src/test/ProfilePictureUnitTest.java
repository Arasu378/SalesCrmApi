package test;

import static org.junit.Assert.assertEquals;
import model.ProfilePictureModel;

import org.junit.Test;

import response.GoogleDriveResponse;
import response.ProfilePictureResponse;
import consumeclass.DeleteProfilePictureClass;
import consumeclass.GetGoogleDriveClass;
import consumeclass.GetProfilePictureClass;
import consumeclass.InsertProfilePictureClass;
import consumeclass.UpdateProfilePictureClass;

public class ProfilePictureUnitTest {
	@Test
	public void getProfilePicturebyProfilePictureId(){
		ProfilePictureResponse response=GetProfilePictureClass.getProfilePicture(100001);
		assertEquals("getProfilePicturebyProfilePictureId",response.getIsSuccess(),true);

		
	}
//	@Test
//	public void insertProfilePicture(){
//		ProfilePictureModel model=new ProfilePictureModel();
//		model.setUserProfileId(100003);
//		model.setAttachmentId(100002);
//		ProfilePictureResponse response=InsertProfilePictureClass.insertProfilePicture(model);
//		assertEquals("insertProfilePicture",response.getIsSuccess(),true);
//	}
//	@Test
//	public void updateProfilePicture(){
//		ProfilePictureModel model=new ProfilePictureModel();
//		model.setProfilePictureId(100004);
//		model.setAttachmentId(100002);
//		ProfilePictureResponse response=UpdateProfilePictureClass.updateProfilePicture(model);
//		assertEquals("updateProfilePicture",response.getIsSuccess(),true);
//	}
	@Test
	public void deleteProfilePicture(){
		ProfilePictureModel model=new ProfilePictureModel();
		model.setProfilePictureId(100004);
		ProfilePictureResponse response=DeleteProfilePictureClass.deleteProfilePicture(model);
		assertEquals("deleteProfilePicture",response.getIsSuccess(),true);
	}
}
