package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetDealByUserProfileIdClass;
import response.DealResponse;

@Path("/getDealByUserProfileId/{UserProfileId}")
public class GetDealByUserProfileIdAPI {
@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public DealResponse getDealByUserProfileId(@PathParam("UserProfileId")int UserProfileId){
	return GetDealByUserProfileIdClass.getDealByUserProfileId(UserProfileId);
}
}
