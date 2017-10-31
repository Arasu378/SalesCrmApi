package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertEmailIntegrationClass;
import model.EmailIntegrationModel;
import response.EmailIntegrationResponse;

@Path("/insertEmailIntegraion")
public class InsertEmailIntegrationAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public EmailIntegrationResponse insertEmailIntegration(EmailIntegrationModel model){
	return InsertEmailIntegrationClass.insertEmailIntegration(model);
}
}
