package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetGoogleDriveClass;
import response.GoogleDriveResponse;

@Path("/getGoogleDrive/{DriveId}")
public class GetGoogleDriveAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public GoogleDriveResponse getGoogleDrive(@PathParam("DriveId")int DriveId){
	return GetGoogleDriveClass.getGoogleDrive(DriveId);
}
}
