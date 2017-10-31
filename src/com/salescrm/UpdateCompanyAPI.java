package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateCompanyClass;
import model.CompanyModel;
import response.CompanyResponse;

@Path("/updateCompanyAPI")
public class UpdateCompanyAPI {
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public CompanyResponse updateCompany(CompanyModel model){
	return UpdateCompanyClass.updateCompany(model);
}
}
