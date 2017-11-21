package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

import consumeclass.GetStagesByUserProfileIdClass;
import response.StagesResponse;

@Path("/getStagesByUserProfileId/{UserProfileId}")

public class GetStagesByUserProfileIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public StagesResponse getStages(@PathParam("UserProfileId")int UserProfileId){
	return GetStagesByUserProfileIdClass.getStages(UserProfileId);
}
}
