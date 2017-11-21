package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.ReminderTypeClass;
import response.ReminderTypeResponse;

@Path("/getReminderType")
public class ReminderTypeAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public ReminderTypeResponse getReminderType(){
	return ReminderTypeClass.getReminderType();
}
}
