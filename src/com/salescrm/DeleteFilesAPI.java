package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteFilesClass;
import model.FilesModel;
import response.FilesResponse;

@Path("/deleteFiles")
public class DeleteFilesAPI {
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public FilesResponse deleteFiles(FilesModel model){
	return DeleteFilesClass.deleteFiles(model);
}
}
