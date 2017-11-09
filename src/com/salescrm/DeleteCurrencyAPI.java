package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteConnectionsClass;
import consumeclass.DeleteCurrencyClass;
import response.CurrencyResponse;
/**  
* DeleteCurrencyAPI.java - DELETE METHOD to delete currency.  
* @author  Thirunavukkarasu v
* @version 1.0 
* @see DeleteCurrencyClass.java
*/
@Path("/deleteCurrency/{CurrencyId}")
public class DeleteCurrencyAPI {
	/**
	   *	Delete method for deleting the currency in database.
	   * 
	   * @param requires the input integer CurrencyId.
	   * @exception Any exception
	   * @return Which returns CurrencyResponse class.
	   */
@GET
@Produces(MediaType.APPLICATION_JSON)
public CurrencyResponse deleteCurrency(@PathParam("CurrencyId")int CurrencyId){
	return DeleteCurrencyClass.deleteCurrency(CurrencyId);
}
}
