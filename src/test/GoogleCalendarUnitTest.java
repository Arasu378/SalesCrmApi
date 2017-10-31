package test;

import static org.junit.Assert.assertEquals;
import model.GoogleCalanderModel;

import org.junit.Test;

import response.ConnectionsResponse;
import response.GoogleCalanderResponse;
import consumeclass.DeleteGoogleCalanderClass;
import consumeclass.GetConnectionsByConnectionIdClass;
import consumeclass.GetGoogleCalanderByConnectionIdClass;
import consumeclass.GetGoogleCalanderByUserProfileIdClass;
import consumeclass.InsertGoogleCalanderClass;
import consumeclass.UpdateGoogleCalanderClass;

public class GoogleCalendarUnitTest {
	@Test
	public void getGoogleCalendarbyUserProfileId(){
		GoogleCalanderResponse response=GetGoogleCalanderByUserProfileIdClass.getGoogleCalander(100001);
		assertEquals("getGoogleCalanderbyUserProfileId",response.getIsSuccess(),true);

		
	}
	@Test
	public void getGoogleCalendarbyConnectionId(){
		GoogleCalanderResponse response=GetGoogleCalanderByConnectionIdClass.getGoogleCalendar(100001);
		assertEquals("getGoogleCalanderbyConnectionId",response.getIsSuccess(),true);

		
	}
//	@Test
//	public void insertGoogleCalendar(){
//		GoogleCalanderModel model=new GoogleCalanderModel();
//		model.setUserProfileId(100001);
//		model.setGoogleAccountEmail("dummy email");
//		model.setIsConnectedToGoogleAccount(true);
//		model.setIsActive(true);
//		GoogleCalanderResponse response=InsertGoogleCalanderClass.insertGoogleCalander(model);
//		assertEquals("insertGoogleCalander",response.getIsSuccess(),true);
//
//		
//	}
//	@Test
//	public void updateGoogleCalander(){
//		GoogleCalanderModel model=new GoogleCalanderModel();
//		model.setConnectionId(100001);
//		model.setGoogleAccountEmail("dummy email");
//		model.setIsConnectedToGoogleAccount(true);
//		model.setIsActive(true);
//		GoogleCalanderResponse response=UpdateGoogleCalanderClass.updateGoogleCalander(model);
//		assertEquals("updateGoogleCalander",response.getIsSuccess(),true);
//	}
	@Test
	public void deleteGoogleCalander(){
		GoogleCalanderModel model=new GoogleCalanderModel();
		model.setConnectionId(100002);
		GoogleCalanderResponse response=DeleteGoogleCalanderClass.deleteGoogleCalander(model);
		assertEquals("deleteGoogleCalander",response.getIsSuccess(),true);
	}
}
