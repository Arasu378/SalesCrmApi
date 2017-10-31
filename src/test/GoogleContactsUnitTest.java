package test;

import static org.junit.Assert.assertEquals;
import model.GoogleContactsModel;

import org.junit.Test;

import response.GoogleCalanderResponse;
import response.GoogleContactsResponse;
import consumeclass.DeleteGoogleContactsClass;
import consumeclass.GetGoogleCalanderByUserProfileIdClass;
import consumeclass.GetGoogleContactsByContactIdClass;
import consumeclass.GetGoogleContactsByUserProfileIdClass;
import consumeclass.InsertGoogleContactsClass;
import consumeclass.UpdateGoogleContactsClass;

public class GoogleContactsUnitTest {
	@Test
	public void getGoogleContactsbyUserProfileId(){
		GoogleContactsResponse response=GetGoogleContactsByUserProfileIdClass.getGoogleContacts(100001);
		assertEquals("getGoogleContactsbyUserProfileId",response.getIsSuccess(),true);

		
	}
	@Test
	public void getGoogleContactsbyContactId(){
		GoogleContactsResponse response=GetGoogleContactsByContactIdClass.getGoogleContacts(100001);
		assertEquals("getGoogleContactsbyContactId",response.getIsSuccess(),true);

		
	}
//	@Test
//	public void insertGoogleContacts(){
//		GoogleContactsModel model=new GoogleContactsModel();
//		model.setUserProfileId(100001);
//		model.setIsConnectedToGoogleAccount(true);
//		model.setGoogleAccountEmail("dummy email");
//		model.setIsActive(true);
//		GoogleContactsResponse response=InsertGoogleContactsClass.insertGoogleContacts(model);
//		assertEquals("insertGoogleContacts",response.getIsSuccess(),true);
//		
//	}
	
//	@Test
//	public void updateGoogleContacts(){
//		GoogleContactsModel model=new GoogleContactsModel();
//		model.setContactId(100001);
//		model.setIsConnectedToGoogleAccount(true);
//		model.setGoogleAccountEmail("dummys email");
//		model.setIsActive(true);
//		GoogleContactsResponse response=UpdateGoogleContactsClass.updateGoogleContacts(model);
//		assertEquals("updateGoogleContacts",response.getIsSuccess(),true);
//	}
	@Test
	public void deleteGoogleContacts(){
		GoogleContactsModel model=new GoogleContactsModel();
		model.setContactId(100001);
		GoogleContactsResponse response=DeleteGoogleContactsClass.deleteGoogleContacts(model);
		assertEquals("deleteGoogleContacts",response.getIsSuccess(),true);
	}
}
