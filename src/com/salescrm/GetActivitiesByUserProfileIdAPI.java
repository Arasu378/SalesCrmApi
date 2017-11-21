package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetActivitiesByUserProfileIdClass;
import response.ActivityResponse;

@Path("/getActivitiesByUserProfileId/{UserProfileId}")
public class GetActivitiesByUserProfileIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public ActivityResponse getActivities(@PathParam("UserProfileId")int UserProfileId){
	return GetActivitiesByUserProfileIdClass.getActivitiesByUserProfileId(UserProfileId);
}
}
