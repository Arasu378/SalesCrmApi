package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdatePipeLineClass;
import model.PipeLineModel;
import response.PipeLineResponse;

@Path("/updatePipeLine")
public class UpdatePipeLineAPI {
@PUT
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public PipeLineResponse updatepipeline(PipeLineModel model){
	return UpdatePipeLineClass.updatePipeLine(model);
}
}
