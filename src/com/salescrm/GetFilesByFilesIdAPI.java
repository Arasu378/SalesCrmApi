package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetFilesByFilesIdClass;
import response.FilesResponse;

@Path("/getFilesByFileId/{FileId}")
public class GetFilesByFilesIdAPI {
@GET
@Produces(MediaType.APPLICATION_JSON)
public FilesResponse getFilesByFileId(@PathParam("FileId")int FileId){
	return GetFilesByFilesIdClass.getFilesByFileId(FileId);
}
}
