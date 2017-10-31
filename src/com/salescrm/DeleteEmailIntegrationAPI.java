package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteEmailintegraionClass;
import model.EmailIntegrationModel;
import response.EmailIntegrationResponse;

@Path("/deleteEmailIntegration")
public class DeleteEmailIntegrationAPI {
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public EmailIntegrationResponse deleteEmailIntegration(EmailIntegrationModel model){
	return DeleteEmailintegraionClass.deleteEmailIntegration(model);
}
}
