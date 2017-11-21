package com.salescrm;

import java.io.FileReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.FilesModel;

import org.apache.catalina.ha.deploy.FileMessage;

import consumeclass.InsertFilesClass;
import response.FilesResponse;

@Path("/insertFile")
public class InsertFileAPI {
@POST
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public FilesResponse insertFiles(FilesModel model){
	return InsertFilesClass.insertFile(model);
}
}
