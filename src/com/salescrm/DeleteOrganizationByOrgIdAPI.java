package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteOrganizationByOrganizationIdClass;
import model.OrganizationModel;
import response.OrganizationResponse;

@Path("/deleteOrganizationByOrgId")
public class DeleteOrganizationByOrgIdAPI {
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public OrganizationResponse deleteOrganization(OrganizationModel model){
	return DeleteOrganizationByOrganizationIdClass.deleteOrganization(model);
}
}
