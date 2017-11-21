package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetEmailIntegrationByEmailIntegrationIdClass;
import response.EmailIntegrationResponse;

@Path("/getEmailIntegraionByEmailIntegraitonId/{EmailIntegrationId}")
public class GetEmailIntegrationByEmailIntegrationIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public EmailIntegrationResponse getEmailIntegraion(@PathParam("EmailIntegrationId")int EmailIntegrationId){
	return GetEmailIntegrationByEmailIntegrationIdClass.getEmailIntegration(EmailIntegrationId);
}
}
