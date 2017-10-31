package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertPersonPipeDriveClass;
import model.PersonModel;
import response.PersonResponse;

@Path("/insertPersonPDrive")
public class InsertPersonPipeDriveAPI {
	@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public PersonResponse insertPersonPipeDrive(PersonModel model){
	return InsertPersonPipeDriveClass.insertPerson(model);
}
}
