package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetUserInterfaceByUserProfileIdClass;
import response.UserInterfaceResponse;

@Path("/getUserInterfaceByUserProfileId/{UserProfileId}")
public class GetUserInterfaceByUserProfileIdAPI {
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public UserInterfaceResponse getUserInterface(@PathParam("UserProfileId")int UserProfileId){
		return GetUserInterfaceByUserProfileIdClass.getUserInterface(UserProfileId);
	}

}
