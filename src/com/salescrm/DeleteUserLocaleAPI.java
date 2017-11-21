package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

import consumeclass.DeleteUserLocaleClass;
import model.UserLocaleModel;
import response.UserLocaleResponse;

@Path("/deleteUserLocale")
public class DeleteUserLocaleAPI {
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public UserLocaleResponse deleteUserLocale(UserLocaleModel model){
	return DeleteUserLocaleClass.deleteUserLocale(model);
}
}
