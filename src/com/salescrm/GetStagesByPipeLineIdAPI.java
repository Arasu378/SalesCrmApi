package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import response.StagesResponse;
import consumeclass.GetStagesByPipeLineIdClass;

@Path("/getStagesByPipeLineId/{PipeLineId}")

public class GetStagesByPipeLineIdAPI {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public StagesResponse getStages(@PathParam("PipeLineId")int PipeLineId){
		return GetStagesByPipeLineIdClass.getStages(PipeLineId);
	}
}
