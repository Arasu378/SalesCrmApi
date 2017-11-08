package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetUsersByUserProfileIdClass;
import response.UsersResponse;

@Path("/getUsersByUserProfileId/{UserProfileId}")
public class GetUsersByUserProfileIdAPI {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static UsersResponse getUsersByUserProfileId(@PathParam("UserProfileId")int UserProfileId){
		return GetUsersByUserProfileIdClass.getUsersByUserProfileId(UserProfileId);
	}

}
