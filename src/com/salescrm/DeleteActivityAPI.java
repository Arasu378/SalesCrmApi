package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteActivityClass;
import model.ActivityModel;
import response.ActivityResponse;
import response.CurrencyResponse;
/**  
* DeleteActivityAPI.java - DELETE METHOD to delete Activity.  
* @author  Thirunavukkarasu v
* @version 1.0 
* @see DeleteActivityClass.java
*/
@Path("/deleteActivity")
public class DeleteActivityAPI {
	/**
	   *	Delete method for deleting the activity in database.
	   * 
	   * @param requires the input ActivityModel class .
	   * @exception Any exception
	   * @return Which returns ActivityResponse class.
	   */ 
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ActivityResponse deleteActivity(ActivityModel model){
	return DeleteActivityClass.deleteActivity(model);
}
}
