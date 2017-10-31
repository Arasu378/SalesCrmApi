package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateUserInterfaceClass;
import model.UserInterfaceModel;
import response.UserInterfaceResponse;

@Path("/updateUserInterface")
public class UpdateUserInterfaceAPI {
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public UserInterfaceResponse updateUserInterface(UserInterfaceModel model){
	return UpdateUserInterfaceClass.updateUserInterface(model);
}
}
