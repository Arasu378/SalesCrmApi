package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.IndustryTypeClass;
import response.IndustryTypeResponse;

@Path("/getIndustryType")
public class IndustryTypeAPI {
@GET
@Produces(MediaType.APPLICATION_JSON)
public IndustryTypeResponse getIndustry(){
	return IndustryTypeClass.getIndustryType();
}
}
