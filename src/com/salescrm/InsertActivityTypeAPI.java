package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertActivityTypeClass;
import model.ActivityTypeModel;
import response.ActivityTypeResponse;

@Path("/insertAcitivityType")
public class InsertActivityTypeAPI {
@POST
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ActivityTypeResponse insertActivityType(ActivityTypeModel model){
	return InsertActivityTypeClass.insertAcitivity(model);
}
}
