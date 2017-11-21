package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetGoogleContactsByUserProfileIdClass;
import response.GoogleContactsResponse;

@Path("/getGoogleContactsByUserProfileId/{UserProfileId}")
public class GetGoogleContactsByUserProfileIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public GoogleContactsResponse getGoogleContacts(@PathParam("UserProfileId")int UserProfileId){
	return GetGoogleContactsByUserProfileIdClass.getGoogleContacts(UserProfileId);
}
}
