package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertPersonClass;
import model.PersonModel;
import response.PersonResponse;

@Path("/insertPerson")
public class InsertPersonAPI {
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@POST
@Secured
public PersonResponse insertPerson(PersonModel model){
	return InsertPersonClass.insertPerson(model);
}
}
