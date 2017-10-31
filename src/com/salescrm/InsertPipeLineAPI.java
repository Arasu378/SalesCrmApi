package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertPipeLineClass;
import model.PipeLineModel;
import response.PipeLineResponse;

@Path("/insertPipeLine")
public class InsertPipeLineAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public PipeLineResponse insertpipeline(PipeLineModel model){
	return InsertPipeLineClass.insertPipeLine(model);
}
}
