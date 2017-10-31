package test;

import static org.junit.Assert.assertEquals;
import model.ReminderEmailModel;

import org.junit.Test;

import response.ProfilePictureResponse;
import response.ReminderEmailResponse;
import consumeclass.DeleteReminderEmailClass;
import consumeclass.GetProfilePictureClass;
import consumeclass.GetReminderEmailByReminderEmailIdClass;
import consumeclass.GetReminderEmailByUserProfileIdClass;
import consumeclass.InsertReminderEmailClass;
import consumeclass.UpdateReminderEmailClass;

public class ReminderEmailsUnitTest {
	@Test
	public void getreminderEmailsbyReminderId(){
		ReminderEmailResponse response=GetReminderEmailByReminderEmailIdClass.getReminder(100001);
		assertEquals("getreminderEmailsbyReminderId",response.getIsSuccess(),true);
		}
	@Test
	public void getreminderEmailsbyUserProfileId(){
		ReminderEmailResponse response=GetReminderEmailByUserProfileIdClass.getReminderEmail(100001);
		assertEquals("getreminderEmailsbyUserProfileId",response.getIsSuccess(),true);
		}
//	@Test
//	public void insertReminderEmails(){
//		ReminderEmailModel model=new ReminderEmailModel();
//		model.setUserProfileId(100001);
//		model.setIsActive(true);
//		model.setReminderTimeId("test");
//		model.setReminderTypeId("test");
//		ReminderEmailResponse response=InsertReminderEmailClass.insertReminderEmail(model);
//		assertEquals("insertreminderEmails",response.getIsSuccess(),true);
//
//	}
//	
//	@Test
//	public void updateReminderEmails(){
//		ReminderEmailModel model=new ReminderEmailModel();
//		model.setReminderEmailId(100002);
//		model.setIsActive(true);
//		model.setReminderTimeId("testj");
//		model.setReminderTypeId("tesjt");
//		ReminderEmailResponse response=UpdateReminderEmailClass.updateReminderEmail(model);
//		assertEquals("updatereminderEmails",response.getIsSuccess(),true);
//	}
	
	@Test
	public void deleteReminderEmails(){
		ReminderEmailModel model=new ReminderEmailModel();
		model.setReminderEmailId(100002);
		ReminderEmailResponse response=DeleteReminderEmailClass.deleteReminder(model);
		assertEquals("deletereminderEmails",response.getIsSuccess(),true);
	}
}
