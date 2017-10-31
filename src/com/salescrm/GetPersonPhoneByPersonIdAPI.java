package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetPersonPhoneByPersonIdClass;
import response.PersonPhoneResponse;
import response.PersonResponse;

@Path("/getPersonPhoneByPersonId/{PersonId}")
public class GetPersonPhoneByPersonIdAPI {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PersonPhoneResponse getPersonPhoneByPersonId(@PathParam("PersonId")int PersonId){
		return GetPersonPhoneByPersonIdClass.getPersonPhone(PersonId);
	}

}

