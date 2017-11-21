package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteUserInterfaceClass;
import model.UserInterfaceModel;
import response.UserInterfaceResponse;

@Path("/deleteUserInterface")
public class DeleteUserInterfaceAPI {
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public UserInterfaceResponse delteUserInterface(UserInterfaceModel model){
	return DeleteUserInterfaceClass.delteUserInterface(model);
}
}
