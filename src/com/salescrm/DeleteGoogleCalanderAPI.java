package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteGoogleCalanderClass;
import model.GoogleCalanderModel;
import response.GoogleCalanderResponse;

@Path("/deleteGoogleCalander")
public class DeleteGoogleCalanderAPI {
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public GoogleCalanderResponse deleteGoogleCalander(GoogleCalanderModel model){
	return DeleteGoogleCalanderClass.deleteGoogleCalander(model);
}
}
