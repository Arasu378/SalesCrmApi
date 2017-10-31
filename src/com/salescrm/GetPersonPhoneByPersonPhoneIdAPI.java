package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetPersonPhoneByPersonPhoneIdClass;
import response.PersonPhoneResponse;

@Path("/getPersonPhoneByPersonPhoneId/{PersonPhoneId}")
public class GetPersonPhoneByPersonPhoneIdAPI {
@GET
@Produces(MediaType.APPLICATION_JSON)
public PersonPhoneResponse getPersonPhoneByPersonPhoneId(@PathParam("PersonPhoneId")int PersonPhoneId){
	return GetPersonPhoneByPersonPhoneIdClass.getPersonPhone(PersonPhoneId);
}
}
