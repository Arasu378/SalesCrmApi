package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

import consumeclass.DeleteGoogleCalanderClass;
import consumeclass.DeleteGoogleContactsClass;
import model.GoogleContactsModel;
import response.GoogleContactsResponse;
/**  
* DeleteGoogleContactsAPI.java - DELETE METHOD to delete google contacts data.  
* @author  Thirunavukkarasu v
* @version 1.0 
* @see DeleteGoogleContactsClass.java
*/
@Path("/deleteGoogleContacts")
public class DeleteGoogleContactsAPI {
	/**
	   *	Delete method for deleting the google contacts  in database.
	   * 
	   * @param requires the input GoogleContactsModel.java class.
	   * @exception Any exception
	   * @return Which returns GoogleContactsResponse.java class.
	   */
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public GoogleContactsResponse deleteGoogleContacts(GoogleContactsModel model){
	return DeleteGoogleContactsClass.deleteGoogleContacts(model);
}
}
