package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateIndustryTypeClass;
import model.IndustryTypeModel;
import response.IndustryTypeResponse;

@Path("/updateIndustryType")
public class UpdateIndustryTypeAPI {
@PUT
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public IndustryTypeResponse updateData(IndustryTypeModel model){
	return UpdateIndustryTypeClass.updateIndustryType(model);
}
}
