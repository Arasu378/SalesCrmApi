package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdatePersonClass;
import model.PersonModel;
import response.PersonResponse;

@Path("/updatePerson")
public class UpdatePersonAPI {
@PUT
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public PersonResponse updatePerson(PersonModel model){
	return UpdatePersonClass.updatePerson(model);
}
}
