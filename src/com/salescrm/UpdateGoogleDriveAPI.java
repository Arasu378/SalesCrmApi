package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

import consumeclass.UpdateGoogleDriveClass;
import model.GoogleDriveModel;
import response.GoogleDriveResponse;

@Path("/updateGoogleDrive")
public class UpdateGoogleDriveAPI {
@PUT
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public GoogleDriveResponse updateGoogleDrive(GoogleDriveModel model){
	return UpdateGoogleDriveClass.updateGoogleDrive(model);
}
}
