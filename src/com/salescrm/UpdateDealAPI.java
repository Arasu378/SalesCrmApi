package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateDealClass;
import model.DealModel;
import response.DealResponse;

@Path("/updateDeal")
public class UpdateDealAPI {
@PUT
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public DealResponse updateDeal(DealModel model){
	return UpdateDealClass.updateDeal(model);
}
}
