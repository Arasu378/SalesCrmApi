package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetConnectionsByUserProfileIdClass;
import response.ConnectionsResponse;

@Path("/getConnectionByUserProfileId/{UserProfileId}")
public class GetConnectionByUserProfileIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public ConnectionsResponse getConnection(@PathParam("UserProfileId")int UserProfileId){
	return GetConnectionsByUserProfileIdClass.getConnection(UserProfileId);
}
}
