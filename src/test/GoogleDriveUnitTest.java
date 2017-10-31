package test;

import static org.junit.Assert.assertEquals;
import model.GoogleDriveModel;

import org.junit.Test;

import consumeclass.DeleteGoogleDriveClass;
import consumeclass.GetGoogleDriveClass;
import consumeclass.InsertGoogleDriveClass;
import consumeclass.UpdateGoogleDriveClass;
import response.GoogleDriveResponse;

public class GoogleDriveUnitTest {
//	public static void main(String[] args) {
//		GoogleDriveResponse response=GetGoogleDriveClass.getGoogleDrive(100001);
//		boolean value=response.getIsSuccess();
//		System.out.println("Success : "+value);
//	}
	@Test
	public void getGoogleDrivebyDriveId(){
		GoogleDriveResponse response=GetGoogleDriveClass.getGoogleDrive(100001);
		assertEquals("getGoogleDrivebyDriveId",response.getIsSuccess(),true);

		
	}
//	@Test
//	public void insertGoogleDrive(){
//		GoogleDriveModel model=new GoogleDriveModel();
//		model.setUserProfileId(100001);
//		model.setIsActive(true);
//		model.setIsConnectedToGoogleAccount(true);
//		model.setGoogleAccountEmail("testemail");
//		GoogleDriveResponse response=InsertGoogleDriveClass.insertGoogleDrive(model);
//		assertEquals("insertGoogleDrive",response.getIsSuccess(),true);
//
//	}
//	@Test
//	public void updateGoogleDrive(){
//		GoogleDriveModel model=new GoogleDriveModel();
//		model.setIsActive(true);
//		model.setDriveId(100002);
//		model.setIsConnectedToGoogleAccount(true);
//		model.setGoogleAccountEmail("testemaied");
//		GoogleDriveResponse response=UpdateGoogleDriveClass.updateGoogleDrive(model);
//		assertEquals("updateGoogleDrive",response.getIsSuccess(),true);
//	}
	@Test
	public void deleteGoogleDrive(){
		GoogleDriveModel model=new GoogleDriveModel();
		model.setDriveId(100002);
		GoogleDriveResponse response=DeleteGoogleDriveClass.deleteGoogleDrive(model);
		assertEquals("deleteGoogleDrive",response.getIsSuccess(),true);
	}
}
