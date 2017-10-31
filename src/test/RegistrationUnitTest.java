package test;

import static org.junit.Assert.assertEquals;
import model.RegistrationModel;

import org.junit.Test;

import response.RegistrationResponse;
import response.ReminderEmailResponse;
import consumeclass.GetReminderEmailByReminderEmailIdClass;
import consumeclass.RegistrationClass;

public class RegistrationUnitTest {
	@Test
	public void registration(){
		RegistrationModel model=new RegistrationModel();
		model.setUserPassword("arasu378");
		model.setEmailAddress("test@gmail.com");
		RegistrationResponse response=RegistrationClass.registration(model);
		String mess=response.getMessage();
		System.out.println("message: "+mess);
		assertEquals("registration",response.getIsSuccess(),false);
		}
}
