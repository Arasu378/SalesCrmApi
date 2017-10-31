package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UserLocaleClass;
import response.UserLocaleResponse;

@Path("/getUserLocale")
public class UserLocaleAPI {
@GET
@Produces(MediaType.APPLICATION_JSON)
public UserLocaleResponse getUserLocale(){
	return UserLocaleClass.getUserLocale();
}
}
