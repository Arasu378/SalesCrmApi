package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetActivityTypeClass;
import response.ActivityTypeResponse;

@Path("/getActivityType")
public class GetActivityTypeAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public ActivityTypeResponse getActivityType(){
	return GetActivityTypeClass.getActivityType();
}
}
