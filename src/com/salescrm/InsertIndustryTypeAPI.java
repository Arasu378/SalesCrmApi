package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.IndustryTypeClass;
import consumeclass.InsertIndustryTypeClass;
import model.IndustryTypeModel;
import response.IndustryTypeResponse;

@Path("/insertIndustryType")
public class InsertIndustryTypeAPI {
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public IndustryTypeResponse insertData(IndustryTypeModel model){
	return InsertIndustryTypeClass.insertdata(model);
}
}
