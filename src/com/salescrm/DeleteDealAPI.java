package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteCurrencyClass;
import consumeclass.DeleteDealClass;
import model.DealModel;
import response.DealResponse;
/**  
* DeleteDealAPI.java - DELETE METHOD to delete deals.  
* @author  Thirunavukkarasu v
* @version 1.0 
* @see DeleteDealClass.java
*/
@Path("/deleteDeal")
public class DeleteDealAPI {
	/**
	   *	Delete method for deleting the deals in database.
	   * 
	   * @param requires the input DealModel class.
	   * @exception Any exception
	   * @return Which returns DeleteDealClass class.
	   */
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public DealResponse deleteDeal(DealModel model){
	return DeleteDealClass.deleteDeal(model);
}
}
