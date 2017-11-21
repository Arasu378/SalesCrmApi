package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteReminderTypeClass;
import model.ReminderTypeModel;
import response.ReminderTypeResponse;

@Path("/deleteReminderType")
public class DeleteReminderTypeAPI {
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ReminderTypeResponse deleteData(ReminderTypeModel model){
	return DeleteReminderTypeClass.deleteReminderType(model);
}
	
}
