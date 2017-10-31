package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertGoogleDriveClass;
import model.GoogleDriveModel;
import response.GoogleDriveResponse;

@Path("/insertGoogleDrive")
public class InsertGoogleDriveAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public GoogleDriveResponse insertGoogleDrive(GoogleDriveModel model){
	return InsertGoogleDriveClass.insertGoogleDrive(model);
}
}
