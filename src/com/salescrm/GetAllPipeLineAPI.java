package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetAllPipeLineClass;
import response.PipeLineResponse;

@Path("/getAllPipeLine")
public class GetAllPipeLineAPI {
@GET
@Produces(MediaType.APPLICATION_JSON)
public PipeLineResponse getallPipeline(){
	return GetAllPipeLineClass.getPipeLine();
}
}
