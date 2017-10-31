package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateStagesClass;
import model.StagesModel;
import response.StagesResponse;

@Path("/updateStages")
public class UpdateStagesAPI {
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public StagesResponse updateStages(StagesModel model){
	return UpdateStagesClass.updateStages(model);
}
}
