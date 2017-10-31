package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetPersonEmailByPersonEmailIdClass;
import response.PersonEmailResponse;

@Path("/getPersonEmailByPersonEmailId/{PersonEmailId}")
public class GetPersonEmailByPersonEmailIdAPI {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PersonEmailResponse getPersonEmailByPersonEmailId(@PathParam("PersonEmailId")int PersonEmailId){
		return GetPersonEmailByPersonEmailIdClass.getPersonEmailByPersonEmailId(PersonEmailId);
	}

}
