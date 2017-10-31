package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetOrganizationByOrganizationIdClass;
import response.OrganizationResponse;

@Path("/getOrganizationByOrganizationId/{OrganizationId}")
public class GetOrganizationByOrganizationIdAPI {
@GET
@Produces(MediaType.APPLICATION_JSON)
public OrganizationResponse getOrganizationByOrganizationId(@PathParam("OrganizationId")int OrganizationId){
	return GetOrganizationByOrganizationIdClass.getOrganizationByUserProfileId(OrganizationId);
}
}
