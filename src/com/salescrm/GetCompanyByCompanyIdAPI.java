package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetCompanyByCompanyIdClass;
import response.CompanyResponse;

@Path("/getCompanyByCompanyId/{CompanyId}")
public class GetCompanyByCompanyIdAPI {
@GET
@Produces(MediaType.APPLICATION_JSON)
public CompanyResponse getcompanyByCompanyId(@PathParam("CompanyId")int CompanyId){
	return GetCompanyByCompanyIdClass.getCompanybyCompanyId(CompanyId);
}
}
