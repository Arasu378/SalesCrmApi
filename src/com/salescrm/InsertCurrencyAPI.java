package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertCurrencyClass;
import model.CurrencyModel;
import response.CurrencyResponse;

@Path("/insertCurrency")
public class InsertCurrencyAPI {
@POST
@Secured
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public CurrencyResponse insertCurrency(CurrencyModel input){
	return InsertCurrencyClass.insertCurrency(input);
}
}
