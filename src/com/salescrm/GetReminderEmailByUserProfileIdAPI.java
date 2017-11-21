package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetReminderEmailByUserProfileIdClass;
import response.ReminderEmailResponse;
@Path("/getReminderEmailByUserProfileId/{UserProfileId}")
public class GetReminderEmailByUserProfileIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public ReminderEmailResponse getReminder(@PathParam("UserProfileId")int UserProfileId){
	return GetReminderEmailByUserProfileIdClass.getReminderEmail(UserProfileId);
}

}
