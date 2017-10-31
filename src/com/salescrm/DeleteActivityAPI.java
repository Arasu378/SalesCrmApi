package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteActivityClass;
import model.ActivityModel;
import response.ActivityResponse;

@Path("/deleteActivity")
public class DeleteActivityAPI {
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ActivityResponse deleteActivity(ActivityModel model){
	return DeleteActivityClass.deleteActivity(model);
}
}
