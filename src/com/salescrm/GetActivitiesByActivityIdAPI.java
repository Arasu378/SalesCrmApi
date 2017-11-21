package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetActivitiesByActivityIdClass;
import response.ActivityResponse;

@Path("/getActivityByActivityId/{ActivityId}")
public class GetActivitiesByActivityIdAPI {
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
public ActivityResponse getActivityByActivityId(@PathParam("ActivityId")int ActivityId){
	return GetActivitiesByActivityIdClass.getActivitiesByUserProfileId(ActivityId);
}
}
