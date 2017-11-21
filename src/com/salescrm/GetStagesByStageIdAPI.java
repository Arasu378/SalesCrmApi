package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetStagesByStageIdClass;
import response.StagesResponse;

@Path("/getStagesByStageId/{StageId}")
public class GetStagesByStageIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public StagesResponse getStagesByStageId(@PathParam("StageId")int StageId){
	return GetStagesByStageIdClass.getStagesByStageId(StageId);
}
}
