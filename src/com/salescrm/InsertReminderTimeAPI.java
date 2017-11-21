package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertReminderTimeClass;
import model.ReminderTimeModel;
import response.ReminderTimeResponse;

@Path("/insertReminderTime")
public class InsertReminderTimeAPI {
@POST
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ReminderTimeResponse insertReminderTime(ReminderTimeModel model){
	return InsertReminderTimeClass.insertReminderTime(model);
}
}
