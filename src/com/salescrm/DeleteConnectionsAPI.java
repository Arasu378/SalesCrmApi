package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteCompanyClass;
import consumeclass.DeleteConnectionsClass;
import model.ConnectionsModel;
import response.ConnectionsResponse;
/**  
* DeleteConnectionsAPI.java - DELETE METHOD to delete connections.  
* @author  Thirunavukkarasu v
* @version 1.0 
* @see DeleteConnectionsClass.java
*/
@Path("/deleteConnections")
public class DeleteConnectionsAPI {
	/**
	   *	Delete method for deleting the connections in database.
	   * 
	   * @param requires the input ConnectionsModel class.
	   * @exception Any exception
	   * @return Which returns ConnectionsResponse class.
	   */
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ConnectionsResponse deleteConnections(ConnectionsModel model){
	return DeleteConnectionsClass.deleteConnections(model);
}
}
