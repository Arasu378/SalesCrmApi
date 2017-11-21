package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertCompanyClass;
import model.CompanyModel;
import response.CompanyResponse;

@Path("/insertCompany")
public class InsertCompanyAPI {
@POST
@Secured
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public CompanyResponse insertCompany(CompanyModel model){
	return InsertCompanyClass.insertCompany(model);
}
}
