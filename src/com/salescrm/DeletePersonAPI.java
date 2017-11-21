package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeletePersonClass;
import model.PersonModel;
import response.PersonResponse;

@Path("/deletePerson")
public class DeletePersonAPI {
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public PersonResponse deletePerson(PersonModel model){
	return DeletePersonClass.deletePerson(model);
}
}
