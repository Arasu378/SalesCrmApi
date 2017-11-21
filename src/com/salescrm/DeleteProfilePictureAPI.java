package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteProfilePictureClass;
import model.ProfilePictureModel;
import response.ProfilePictureResponse;

@Path("/deleteProfilePicture")
public class DeleteProfilePictureAPI {
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ProfilePictureResponse deleteProfilePicture(ProfilePictureModel model){
	return DeleteProfilePictureClass.deleteProfilePicture(model);
}
}
