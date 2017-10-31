package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertDealsClass;
import model.DealModel;
import response.DealResponse;

@Path("/insertDeal")
public class InsertDealAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public DealResponse insertDeal(DealModel model){
	return InsertDealsClass.insertDeal(model);
}
}
