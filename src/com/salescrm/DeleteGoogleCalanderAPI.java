package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteFilesClass;
import consumeclass.DeleteGoogleCalanderClass;
import model.GoogleCalanderModel;
import response.GoogleCalanderResponse;
/**  
* DeleteGoogleCalanderAPI.java - DELETE METHOD to delete google calendar data.  
* @author  Thirunavukkarasu v
* @version 1.0 
* @see DeleteGoogleCalanderClass.java
*/
@Path("/deleteGoogleCalander")
public class DeleteGoogleCalanderAPI {
	/**
	   *	Delete method for deleting the google calendar  in database.
	   * 
	   * @param requires the input GoogleCalanderModel.java class.
	   * @exception Any exception
	   * @return Which returns GoogleCalanderResponse.java class.
	   */
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public GoogleCalanderResponse deleteGoogleCalander(GoogleCalanderModel model){
	return DeleteGoogleCalanderClass.deleteGoogleCalander(model);
}
}
