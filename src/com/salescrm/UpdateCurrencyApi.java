package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateCurrencyClass;
import model.CurrencyModel;
import response.CurrencyResponse;

@Path("/updateCurrency")
public class UpdateCurrencyApi {
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public CurrencyResponse updateCurrency(CurrencyModel input){
	return UpdateCurrencyClass.updateCurrency(input);
}
}
