package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetDealByDealIdClass;
import response.DealResponse;

@Path("/getDealByDealId/{DealId}")
public class GetDealByDealIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public DealResponse getDealByDealId(@PathParam("DealId")int DealId){
	return GetDealByDealIdClass.getDealByDealId(DealId);
}
}
