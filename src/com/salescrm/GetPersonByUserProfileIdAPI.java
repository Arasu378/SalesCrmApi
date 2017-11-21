package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetPersonByUserProfileIdClass;
import response.PersonResponse;

@Path("/getPersonByUserProfileId/{UserProfileId}")
public class GetPersonByUserProfileIdAPI {
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public PersonResponse getPersonByUserProfileId(@PathParam("UserProfileId")int UserProfileId){
		return GetPersonByUserProfileIdClass.getPersonByUserProfileId(UserProfileId);
	}

}
