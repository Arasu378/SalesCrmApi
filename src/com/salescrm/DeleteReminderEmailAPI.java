package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteReminderEmailClass;
import response.ReminderEmailResponse;
import model.ReminderEmailModel;

@Path("/deleteReminderEmail")
public class DeleteReminderEmailAPI {
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ReminderEmailResponse deleteReminderEmail(ReminderEmailModel model){
	return DeleteReminderEmailClass.deleteReminder(model);
}
}
