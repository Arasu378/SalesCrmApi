package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateGoogleCalanderClass;
import model.GoogleCalanderModel;
import response.GoogleCalanderResponse;

@Path("/updateGoogleCalander")
public class UpdateGoogleCalanderAPI {
@PUT
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public GoogleCalanderResponse updateGoogleCalander(GoogleCalanderModel model){
	return UpdateGoogleCalanderClass.updateGoogleCalander(model);
}
}
