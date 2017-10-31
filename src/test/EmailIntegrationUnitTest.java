package test;

import static org.junit.Assert.assertEquals;
import model.EmailIntegrationModel;

import org.junit.Test;

import response.CurrencyResponse;
import response.EmailIntegrationResponse;
import consumeclass.CurrencyClass;
import consumeclass.DeleteEmailintegraionClass;
import consumeclass.GetEmailIntegrationByEmailIntegrationIdClass;
import consumeclass.GetEmailIntegrationByUserProfileIdClass;
import consumeclass.InsertEmailIntegrationClass;
import consumeclass.UpdateEmailIntegrationClass;

public class EmailIntegrationUnitTest {
	@Test
	public void getEmailIntegrationByUserProfileId(){
	EmailIntegrationResponse res=GetEmailIntegrationByUserProfileIdClass.getEmailIntegrationByUserProfileId(100001);
	assertEquals("getEmailIntegration",res.getIsSuccess(),true);
	}
	@Test
	public void getEmailIntegrationByEmailIntegrationId(){
	EmailIntegrationResponse res=GetEmailIntegrationByEmailIntegrationIdClass.getEmailIntegration(100001);
	assertEquals("getEmailIntegration",res.getIsSuccess(),true);
	}
//	@Test
//	public void insertEmailIntegration(){
//		EmailIntegrationModel model=new EmailIntegrationModel();
//		model.setUserProfileId(100001);
//		model.setAlternativeEmailAddress("sample");
//		model.setIsMyLinkedEmailsShared(true);
//		model.setIsMyEmailConversationsPrivate(true);
//		model.setIsLinkMyEmailManually(false);
//		model.setIsEmailLinkWithDeals(true);
//		model.setIsActive(true);
//		EmailIntegrationResponse res=InsertEmailIntegrationClass.insertEmailIntegration(model);
//		assertEquals("insertEmailIntegration",res.getIsSuccess(),true);
//		
//	}
//	@Test
//	public void updateEmailIntegration(){
//		EmailIntegrationModel model=new EmailIntegrationModel();
//		model.setUserProfileId(100001);
//		model.setAlternativeEmailAddress("sample");
//		model.setIsMyLinkedEmailsShared(true);
//		model.setIsMyEmailConversationsPrivate(true);
//		model.setIsLinkMyEmailManually(false);
//		model.setIsEmailLinkWithDeals(true);
//		model.setIsActive(true);
//		model.setEmailIntegrationId(100002);
//		EmailIntegrationResponse res=UpdateEmailIntegrationClass.updateEmailIntegration(model);
//		assertEquals("updateEmailIntegration",res.getIsSuccess(),true);
//	}
//	
	@Test
	public void deleteEmailIntegration(){
		EmailIntegrationModel model=new EmailIntegrationModel();
		model.setEmailIntegrationId(100002);
		EmailIntegrationResponse res=DeleteEmailintegraionClass.deleteEmailIntegration(model);
		assertEquals("deleteEmailIntegration",res.getIsSuccess(),true);
	}
}
