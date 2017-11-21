package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.CurrencyClass;
import response.CurrencyResponse;
/**  
* CurrencyAPI.java - GET METHOD to retrieve the currency.  
* @author  Thirunavukkarasu v
* @version 1.0 
* @see CurrencyClass.java
*/
@Path("/getCurrency")
public class CurrencyAPI {
	 /**
	   *
	   * 
	   * @param which does not requires input parameter.
	   * the command line arguments.
	   * @exception Any exception
	   * @return Which returns CurrencyResponse class.
	   */ 
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public CurrencyResponse getCurrency(){
		return CurrencyClass.getCurrency();
	}

}
