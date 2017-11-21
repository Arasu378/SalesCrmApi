package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertUserInterfaceClass;
import model.UserInterfaceModel;
import response.UserInterfaceResponse;

@Path("/insertUserInterface")
public class InsertUserInterfaceAPI {
@POST
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public UserInterfaceResponse insertUserInterface(UserInterfaceModel model){
	return InsertUserInterfaceClass.insertUserInterface(model);
}
}
