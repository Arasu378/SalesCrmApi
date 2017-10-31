package test;

import static org.junit.Assert.assertEquals;
import model.ConnectionsModel;

import org.junit.Test;

import response.ConnectionsResponse;
import consumeclass.DeleteConnectionsClass;
import consumeclass.GetConnectionsByConnectionIdClass;
import consumeclass.GetConnectionsByUserProfileIdClass;
import consumeclass.InsertConnectionsClass;
import consumeclass.UpdateConnectionsClass;

public class ConnectionsUnitTest {
	@Test
	public void getConnectionsbyConnectionId(){
		ConnectionsResponse response=GetConnectionsByConnectionIdClass.getConnections(100001);
		assertEquals("getConnectionsbyConnectionId",response.getIsSuccess(),true);

		
	}
	@Test
	public void getConnectionsbyUserProfileId(){
		ConnectionsResponse response=GetConnectionsByUserProfileIdClass.getConnection(100001);
		assertEquals("getConnectionsbyUserProfileId",response.getIsSuccess(),true);

		
	}
//	@Test
//	public void insertConnections(){
//		ConnectionsModel model=new ConnectionsModel();
//		model.setUserProfileId(100001);
//		model.setIsConnectedToGoogleAccount(true);
//		model.setIsConnectedToMailChimpAccount(false);
//		model.setMailChimpAccountEmail("email");
//		model.setGoogleAccountEmail("goosl");
//		ConnectionsResponse response=InsertConnectionsClass.insertConnection(model);
//		assertEquals("insertConnections",response.getIsSuccess(),true);
//	}
	
//	@Test
//	public void updateConnections(){
//		ConnectionsModel model=new ConnectionsModel();
//		model.setUserProfileId(100001);
//		model.setIsConnectedToGoogleAccount(true);
//		model.setIsConnectedToMailChimpAccount(false);
//		model.setMailChimpAccountEmail("emaild");
//		model.setGoogleAccountEmail("goosld");
//		model.setConnectionId(100002);
//		model.setIsActive(true);
//		ConnectionsResponse response=UpdateConnectionsClass.updateConnections(model);
//		assertEquals("updateConnections",response.getIsSuccess(),true);
//		
//	}
	@Test
	public void deleteConnections(){
		ConnectionsModel model=new ConnectionsModel();
		model.setConnectionId(100002);
		ConnectionsResponse response=DeleteConnectionsClass.deleteConnections(model);
		assertEquals("deleteConnections",response.getIsSuccess(),true);
	}
}
