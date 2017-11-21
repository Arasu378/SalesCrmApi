package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertReminderEmailClass;
import model.ReminderEmailModel;
import response.ReminderEmailResponse;
@Path("/insertReminderEmail")
public class InsertReminderEmailAPI {
@POST
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ReminderEmailResponse insertReminderEmail(ReminderEmailModel model){
	return InsertReminderEmailClass.insertReminderEmail(model);
}
}
