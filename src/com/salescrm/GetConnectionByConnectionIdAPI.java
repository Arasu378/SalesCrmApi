package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetConnectionsByConnectionIdClass;
import response.ConnectionsResponse;

@Path("/getConnectionByConnectionId/{ConnectionId}")
public class GetConnectionByConnectionIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public ConnectionsResponse getConnections(@PathParam("ConnectionId")int ConnectionId){
	return GetConnectionsByConnectionIdClass.getConnections(ConnectionId);
}
}
