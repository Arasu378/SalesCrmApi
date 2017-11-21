package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateEmailIntegrationClass;
import model.EmailIntegrationModel;
import response.EmailIntegrationResponse;

@Path("/updateEmailIntegration")
public class UpdateEmailIntegrationAPi {
@PUT
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public EmailIntegrationResponse updateEmailIntegration(EmailIntegrationModel model){
	return UpdateEmailIntegrationClass.updateEmailIntegration(model);
}
}
