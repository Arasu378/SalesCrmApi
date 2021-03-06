package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.ReminderTimeClass;
import response.ReminderTimeResponse;

@Path("/getReminderTime")
public class ReminderTimeAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public ReminderTimeResponse getReminder(){
	return ReminderTimeClass.getReminderTime();
}
}
