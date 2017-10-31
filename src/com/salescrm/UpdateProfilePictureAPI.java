package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateProfilePictureClass;
import model.ProfilePictureModel;
import response.ProfilePictureResponse;

@Path("/updateProfilePicture")
public class UpdateProfilePictureAPI {
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ProfilePictureResponse updateProfilePicture(ProfilePictureModel model){
	return UpdateProfilePictureClass.updateProfilePicture(model);
}
}
