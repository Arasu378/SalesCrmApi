package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertActivityClass;
import model.ActivityModel;
import response.ActivityResponse;

@Path("/insertActivity")
public class InsertActivityAPI {
@POST
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ActivityResponse insertActivity(ActivityModel model){
	return InsertActivityClass.insertActivity(model);
}
}
