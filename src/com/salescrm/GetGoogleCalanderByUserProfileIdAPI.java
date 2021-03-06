package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetGoogleCalanderByUserProfileIdClass;
import response.GoogleCalanderResponse;

@Path("/getGoogleCalanderByUserProfileId/{UserProfileId}")
public class GetGoogleCalanderByUserProfileIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public GoogleCalanderResponse getGoogleCalander(@PathParam("UserProfileId")int UserProfileId){
	return GetGoogleCalanderByUserProfileIdClass.getGoogleCalander(UserProfileId);
}
}
