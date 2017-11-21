package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetActivityTypePipeDriveByUserProfielIdClass;
import response.ActivityTypeResponse;

@Path("/getActivityTypeByUserProfileId/{UserProfileId}")
public class GetActivityTypePipeDriveByUserProfileIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public ActivityTypeResponse getActivityTypeByUserProfileId(@PathParam("UserProfileId")int UserProfileId){
	return GetActivityTypePipeDriveByUserProfielIdClass.getActivityTypeByUserProfileId(UserProfileId);
}
}
