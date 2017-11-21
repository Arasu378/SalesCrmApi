package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

import consumeclass.DeleteGoogleContactsClass;
import consumeclass.DeleteGoogleDriveClass;
import model.GoogleDriveModel;
import response.GoogleDriveResponse;

/**  
* DeleteGoogleDriveAPI.java - DELETE METHOD to delete google drive data.  
* @author  Thirunavukkarasu v
* @version 1.0 
* @see DeleteGoogleDriveClass.java
*/
@Path("/deleteGoogleDrive")
public class DeleteGoogleDriveAPI {
	/**
	   *	Delete method for deleting the google drive  in database.
	   * 
	   * @param requires the input GoogleDriveModel.java class.
	   * @exception Any exception
	   * @return Which returns GoogleDriveResponse.java class.
	   */
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public GoogleDriveResponse deleteGoogleDrive(GoogleDriveModel model ){
	return DeleteGoogleDriveClass.deleteGoogleDrive(model);
}
}
