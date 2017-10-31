package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.RegistrationOtherDetailsClass;
import model.RegistrationModel;
import response.RegistrationResponse;

@Path("/registrationMoreDetails")
public class RegistrationOtherDetailsAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public RegistrationResponse insertData(RegistrationModel model){
	return RegistrationOtherDetailsClass.insertOtherDetails(model);
}
}
