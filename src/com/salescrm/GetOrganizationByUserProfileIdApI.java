package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetOrganizationByUserProfileIdClass;
import response.OrganizationResponse;

@Path("/getOrganizationByUserProfileId/{UserProfileId}")
public class GetOrganizationByUserProfileIdApI {
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public OrganizationResponse getOrganization(@PathParam("UserProfileId")int UserProfileId){
		return GetOrganizationByUserProfileIdClass.getOrganizationByUserProfileId(UserProfileId);
	}

}
