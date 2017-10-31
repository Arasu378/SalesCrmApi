package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateConnectionsClass;
import model.ConnectionsModel;
import response.ConnectionsResponse;

@Path("/updateConnections")
public class UpdateConnectionsAPI {
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ConnectionsResponse updateConnections(ConnectionsModel model){
	return UpdateConnectionsClass.updateConnections(model);
}
}
