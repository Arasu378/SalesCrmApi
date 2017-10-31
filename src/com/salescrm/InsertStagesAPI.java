package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertStagesClass;
import model.StagesModel;
import response.StagesResponse;

@Path("/insertStages")
public class InsertStagesAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public StagesResponse insertStages(StagesModel model){
	return InsertStagesClass.insertStages(model);
}
}
