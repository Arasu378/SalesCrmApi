package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteReminderTimeClass;
import model.ReminderTimeModel;
import response.ReminderTimeResponse;

@Path("/deleteReminderTime")
public class DeleteReminderTimeAPI {
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ReminderTimeResponse deleteRemindertime(ReminderTimeModel model){
	return DeleteReminderTimeClass.deleteReminderTime(model);
}
}
