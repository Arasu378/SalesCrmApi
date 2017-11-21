package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateActivityTypeClass;
import model.ActivityTypeModel;
import response.ActivityTypeResponse;

@Path("/updateActivityType")
public class UpdateActivityTypeAPI {
@PUT
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ActivityTypeResponse updateActivityType(ActivityTypeModel model){
	return UpdateActivityTypeClass.updateActivityType(model);
}
}
