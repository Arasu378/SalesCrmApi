package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteEmailintegraionClass;
import model.EmailIntegrationModel;
import response.EmailIntegrationResponse;
/**  
* DeleteEmailIntegrationAPI.java - DELETE METHOD to delete emails.  
* @author  Thirunavukkarasu v
* @version 1.0 
* @see DeleteEmailintegraionClass.java
*/

@Path("/deleteEmailIntegration")
public class DeleteEmailIntegrationAPI {
	/**
	   *	Delete method for deleting the email integration in database.
	   * 
	   * @param requires the input EmailIntegrationModel class.
	   * @exception Any exception
	   * @return Which returns EmailIntegrationResponse class.
	   */
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public EmailIntegrationResponse deleteEmailIntegration(EmailIntegrationModel model){
	return DeleteEmailintegraionClass.deleteEmailIntegration(model);
}
}
