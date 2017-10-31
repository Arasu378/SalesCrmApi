package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteStagesClass;
import model.StagesModel;
import response.StagesResponse;

@Path("/deleteStages")
public class DeleteStagesAPI {
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public StagesResponse deleteStages(StagesModel model){
	return DeleteStagesClass.deleteStage(model);
}
}
