package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertOrganizationClass;
import model.OrganizationModel;
import response.OrganizationResponse;

@Path("/insertOrganization")
public class InsertOrganizationAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public OrganizationResponse insertOrganization(OrganizationModel model){
	return InsertOrganizationClass.insertOrganization(model);
}
}
