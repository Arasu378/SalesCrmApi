package test;

import static org.junit.Assert.assertEquals;
import model.UserInterfaceModel;

import org.junit.Test;

import response.ReminderEmailResponse;
import response.UserInterfaceResponse;
import consumeclass.DeleteUserInterfaceClass;
import consumeclass.GetReminderEmailByReminderEmailIdClass;
import consumeclass.GetUserInterfaceByUserInterfaceIdClass;
import consumeclass.GetUserInterfaceByUserProfileIdClass;
import consumeclass.InsertUserInterfaceClass;
import consumeclass.UpdateUserInterfaceClass;

public class UserInterfaceUnitTest {
	@Test
	public void getUserInterfacebyUserProfileId(){
		UserInterfaceResponse response=GetUserInterfaceByUserProfileIdClass.getUserInterface(100001);
		assertEquals("getUserInterfacebyUserProfileId",response.getIsSuccess(),true);
		}
	@Test
	public void getUserInterfacebyUserInterfaceId(){
		UserInterfaceResponse response=GetUserInterfaceByUserInterfaceIdClass.getUserInterface(100001);
		assertEquals("getUserInterfacebyUserInterfaceId",response.getIsSuccess(),true);
		}
	
	
//	@Test
//	public void insertUserInterface(){
//		UserInterfaceModel model=new UserInterfaceModel();
//		model.setUserProfileId(100001);
//		model.setIsActive(true);
//		model.setIsDeal(true);
//		model.setIsOrganization(true);
//		model.setIsPerson(true);
//		
//		UserInterfaceResponse response=InsertUserInterfaceClass.insertUserInterface(model);
//		assertEquals("insertUserInterface",response.getIsSuccess(),true);
//
//	}
//	@Test
//	public void updateUserInterface(){
//		UserInterfaceModel model=new UserInterfaceModel();
//		model.setUserProfileId(100001);
//		model.setIsActive(false);
//		model.setIsDeal(false);
//		model.setIsOrganization(false);
//		model.setIsPerson(false);
//		model.setUserInterfaceId(100002);
//		
//		UserInterfaceResponse response=UpdateUserInterfaceClass.updateUserInterface(model);
//		assertEquals("updateUserInterface",response.getIsSuccess(),true);
//	}
	
	@Test
	public void deleteUserInterface(){
		UserInterfaceModel model=new UserInterfaceModel();
		model.setUserInterfaceId(100002);
		UserInterfaceResponse response=DeleteUserInterfaceClass.delteUserInterface(model);
		assertEquals("deleteUserInterface",response.getIsSuccess(),true);
	}
}
