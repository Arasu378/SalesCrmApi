package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateOragnizationClass;
import model.OrganizationModel;
import response.OrganizationResponse;

@Path("/updateOrganization")
public class UpdateOrganizationAPI {
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public OrganizationResponse updateOrganization(OrganizationModel model){
	return UpdateOragnizationClass.updateOrganization(model);
}
}
