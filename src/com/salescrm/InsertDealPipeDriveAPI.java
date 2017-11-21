package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertDealPipeDriveClass;
import model.DealModel;
import response.DealResponse;

@Path("/insertDealPDrive")
public class InsertDealPipeDriveAPI {
@POST
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public DealResponse insertDealPipeDrive(DealModel model){
	return InsertDealPipeDriveClass.insertDealPipeDrive(model);
}
}
