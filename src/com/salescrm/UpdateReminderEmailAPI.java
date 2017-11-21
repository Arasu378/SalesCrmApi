package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateReminderEmailClass;
import model.ReminderEmailModel;
import response.ReminderEmailResponse;

@Path("/updateReminderEmail")
public class UpdateReminderEmailAPI {
@PUT
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ReminderEmailResponse updateReminderEmail(ReminderEmailModel model){
	return UpdateReminderEmailClass.updateReminderEmail(model);
}
}
