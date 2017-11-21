package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

import consumeclass.InsertReminderTypeClass;
import model.ReminderTypeModel;
import response.ReminderTypeResponse;

@Path("/insertReminderType")
public class InsertReminderTypeAPI {
@POST
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ReminderTypeResponse insertData(ReminderTypeModel model){
	return InsertReminderTypeClass.insertReminderType(model);
}
}
