package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeletePipeLineClass;
import model.PipeLineModel;
import response.PipeLineResponse;

@Path("/deletePipeLine")
public class DeletePipeLineAPI {
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public static PipeLineResponse deletePIpeline(PipeLineModel model){
	return DeletePipeLineClass.deletePipeLine(model);
}
}
