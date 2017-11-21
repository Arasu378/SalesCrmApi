package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateFilesClass;
import model.FilesModel;
import response.FilesResponse;

@Path("/updateFiles")
public class UpdateFilesAPI {
@PUT
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public FilesResponse updateFiles(FilesModel model){
	return UpdateFilesClass.updateFile(model);
}
}
