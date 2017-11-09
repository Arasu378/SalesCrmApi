package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteActivityClass;
import consumeclass.DeleteActivityTypeClass;
import model.ActivityTypeModel;
import response.ActivityTypeResponse;
/**  
* DeleteActivityTypeAPI.java - DELETE METHOD to delete ActivityType.  
* @author  Thirunavukkarasu v
* @version 1.0 
* @see DeleteActivityTypeClass.java
*/
@Path("/deleteActivityType")
public class DeleteActivityTypeAPI {
	/**
	   *	Delete method for deleting the activitytype in database.
	   * 
	   * @param requires the input ActivityTypeModel class .
	   * @exception Any exception
	   * @return Which returns ActivityTypeResponse class.
	   */ 
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ActivityTypeResponse deleteActivityType(ActivityTypeModel model){
	return DeleteActivityTypeClass.deleteActivityType(model);
}
}
