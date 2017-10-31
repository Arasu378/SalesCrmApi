package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteIndustryTypeClass;
import model.IndustryTypeModel;
import response.IndustryTypeResponse;

@Path("/deleteIndustryType")
public class DeleteIndustryTypeAPI {
@DELETE
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public IndustryTypeResponse deleteData(IndustryTypeModel model){
	return DeleteIndustryTypeClass.deleteIndustryType(model);
}
}
