package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteActivityTypeClass;
import model.ActivityTypeModel;
import response.ActivityTypeResponse;

@Path("/deleteActivityType")
public class DeleteActivityTypeAPI {
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ActivityTypeResponse deleteActivityType(ActivityTypeModel model){
	return DeleteActivityTypeClass.deleteActivityType(model);
}
}
