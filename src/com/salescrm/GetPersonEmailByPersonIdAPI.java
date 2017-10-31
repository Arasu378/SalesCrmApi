package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetPersonEmailByPersonIdClass;
import response.PersonEmailResponse;

@Path("/getPersonEmailByPersonId/{PersonId}")
public class GetPersonEmailByPersonIdAPI {
@GET
@Produces(MediaType.APPLICATION_JSON)
public PersonEmailResponse getPersonEmailByPersonId(@PathParam("PersonId")int PersonId){
	return GetPersonEmailByPersonIdClass.getPersonEmailByPersonId(PersonId);
}
}
