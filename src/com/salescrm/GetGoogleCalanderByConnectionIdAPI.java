package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetGoogleCalanderByConnectionIdClass;
import response.GoogleCalanderResponse;

@Path("/getGoogleCalanderByConnectionId/{ConnectionId}")
public class GetGoogleCalanderByConnectionIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public GoogleCalanderResponse getGoogleCalander(@PathParam("ConnectionId")int ConnectionId){
	return GetGoogleCalanderByConnectionIdClass.getGoogleCalendar(ConnectionId);
}
}
