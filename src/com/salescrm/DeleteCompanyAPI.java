package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

import consumeclass.DeleteCompanyClass;
import model.CompanyModel;
import response.CompanyResponse;

@Path("/deleteCompany")
public class DeleteCompanyAPI {
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public CompanyResponse deleteCompany(CompanyModel model){
	return DeleteCompanyClass.deleteCompany(model);
}
}
