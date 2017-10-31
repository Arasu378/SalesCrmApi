package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetPipeLineByUserProfileIdClass;
import response.PipeLineResponse;

@Path("/getPipeLineByUserProfileId/{UserProfileId}")
public class GetPipeLineByUserProfileIdAPI {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PipeLineResponse getPipeline(@PathParam("UserProfileId")int UserProfileId){
		return GetPipeLineByUserProfileIdClass.getPipeLine(UserProfileId);
	}

}
