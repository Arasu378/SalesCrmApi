package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteDealClass;
import model.DealModel;
import response.DealResponse;

@Path("/delete")
public class DeleteDealAPI {
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public DealResponse deleteDeal(DealModel model){
	return DeleteDealClass.deleteDeal(model);
}
}
