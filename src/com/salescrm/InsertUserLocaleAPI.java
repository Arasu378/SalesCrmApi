package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertUserLocaleClass;
import model.UserLocaleModel;
import response.UserLocaleResponse;

@Path("/insertUserLocale")
public class InsertUserLocaleAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public UserLocaleResponse insertUserLocale(UserLocaleModel model){
	return InsertUserLocaleClass.insertUserLocale(model);
}
}
