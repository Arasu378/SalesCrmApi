package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateUserLocaleClass;
import model.UserLocaleModel;
import response.UserLocaleResponse;

@Path("/updateUserLocale")
public class UpdateUserLocaleAPI {
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public UserLocaleResponse updateData(UserLocaleModel model){
	return UpdateUserLocaleClass.updateUserLocale(model);
}
}
