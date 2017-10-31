package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.CurrencyClass;
import response.CurrencyResponse;

@Path("/getCurrency")
public class CurrencyAPI {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CurrencyResponse getCurrency(){
		return CurrencyClass.getCurrency();
	}

}
