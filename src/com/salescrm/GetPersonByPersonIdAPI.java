package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetPersonByPersonIdClass;
import response.PersonResponse;

@Path("/getPersonByPersonId/{PersonId}")
public class GetPersonByPersonIdAPI {
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public PersonResponse getPerson(@PathParam("PersonId")int PersonId){
		return GetPersonByPersonIdClass.getPersonByPersonId(PersonId);
	}

}
