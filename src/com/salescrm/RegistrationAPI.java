package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.RegistrationClass;
import model.RegistrationModel;
import response.RegistrationResponse;

@Path("/registration")
public class RegistrationAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public RegistrationResponse registration(RegistrationModel model){
	
	return RegistrationClass.registration(model);
}
}
