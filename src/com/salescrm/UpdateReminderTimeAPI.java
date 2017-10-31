package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateReminderTimeClass;
import model.ReminderTimeModel;
import response.ReminderTimeResponse;

@Path("/updateReminderTime")
public class UpdateReminderTimeAPI {
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ReminderTimeResponse updateData(ReminderTimeModel  model){
	return UpdateReminderTimeClass.updateReminderTime(model);
}
}
