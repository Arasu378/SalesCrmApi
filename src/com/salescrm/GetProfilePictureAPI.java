package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetProfilePictureClass;
import response.ProfilePictureResponse;

@Path("/getProfilePicture/{ProfilePictureId}")
public class GetProfilePictureAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ProfilePictureResponse getProfilePicture(@PathParam("ProfilePictureId") int ProfilePictureId){
	return GetProfilePictureClass.getProfilePicture(ProfilePictureId);
}
}
