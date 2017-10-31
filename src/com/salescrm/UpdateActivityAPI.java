package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateActivityClass;
import model.ActivityModel;
import model.ActivityTypeModel;
import response.ActivityResponse;

@Path("/updateActivity")
public class UpdateActivityAPI {
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ActivityResponse updateActivity(ActivityModel model){
	return UpdateActivityClass.updateActivity(model);
}
}
