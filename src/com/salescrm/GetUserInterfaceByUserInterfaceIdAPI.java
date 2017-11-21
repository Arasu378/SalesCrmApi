package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetUserInterfaceByUserInterfaceIdClass;
import response.UserInterfaceResponse;

@Path("/getUserInterfaceByUserInterfaceId/{UserInterfaceId}")
public class GetUserInterfaceByUserInterfaceIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public UserInterfaceResponse getUserInterface(@PathParam("UserInterfaceId")int UserInterfaceId){
	return GetUserInterfaceByUserInterfaceIdClass.getUserInterface(UserInterfaceId);
}
}
