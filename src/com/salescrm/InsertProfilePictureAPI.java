package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertProfilePictureClass;
import model.ProfilePictureModel;
import response.ProfilePictureResponse;

@Path("/insertProfilePicture")
public class InsertProfilePictureAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ProfilePictureResponse insertProfilePicture(ProfilePictureModel model){
	return InsertProfilePictureClass.insertProfilePicture(model);
}
}
