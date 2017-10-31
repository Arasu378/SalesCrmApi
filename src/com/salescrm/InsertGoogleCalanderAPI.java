package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertGoogleCalanderClass;
import model.GoogleCalanderModel;
import response.GoogleCalanderResponse;

@Path("/insertGoogleCalander")
public class InsertGoogleCalanderAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public GoogleCalanderResponse insertGoogleCalander(GoogleCalanderModel model){
	return InsertGoogleCalanderClass.insertGoogleCalander(model);
}
}
