package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteCurrencyClass;
import response.CurrencyResponse;

@Path("/deleteCurrency/{CurrencyId}")
public class DeleteCurrencyAPI {
@GET
@Produces(MediaType.APPLICATION_JSON)
public CurrencyResponse deleteCurrency(@PathParam("CurrencyId")int CurrencyId){
	return DeleteCurrencyClass.deleteCurrency(CurrencyId);
}
}
