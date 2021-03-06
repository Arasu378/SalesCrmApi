package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetEmailIntegrationByUserProfileIdClass;
import response.EmailIntegrationResponse;

@Path("/getEmailIntegrationByUserProfileId/{UserProfileId}")
public class GetEmailIntegrationByUserProfileIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public EmailIntegrationResponse getEmailIntegration(@PathParam("UserProfileId")int UserProfileId){
	return GetEmailIntegrationByUserProfileIdClass.getEmailIntegrationByUserProfileId(UserProfileId);
}
}
