package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteConnectionsClass;
import model.ConnectionsModel;
import response.ConnectionsResponse;

@Path("/deleteConnections")
public class DeleteConnectionsAPI {
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ConnectionsResponse deleteConnections(ConnectionsModel model){
	return DeleteConnectionsClass.deleteConnections(model);
}
}
