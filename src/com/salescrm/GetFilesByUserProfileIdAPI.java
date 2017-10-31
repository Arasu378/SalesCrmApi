package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetFilesByUserProfileIdClass;
import response.FilesResponse;

@Path("/getFilesByUserProfileId/{UserProfileId}")
public class GetFilesByUserProfileIdAPI {
@GET
@Produces(MediaType.APPLICATION_JSON)
public FilesResponse getfilesByUserProfileId(@PathParam("UserProfileId")int UserProfileId){
	return GetFilesByUserProfileIdClass.getFilesByUserProfileId(UserProfileId);
}
}
