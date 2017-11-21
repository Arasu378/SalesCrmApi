package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetCompanyByUserProfileIdClass;
import response.CompanyResponse;

@Path("/getCompanyByUserProfileId/{UserProfileId}")
public class GetCompanyByUserProfileIdAPI {
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
public CompanyResponse getCompanybyUserProfileId(@PathParam("UserProfileId")int UserProfileId){
	return GetCompanyByUserProfileIdClass.getCompanyByUserProfileId(UserProfileId);
}
}
