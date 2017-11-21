package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteEmailintegraionClass;
import consumeclass.DeleteFilesClass;
import model.FilesModel;
import response.FilesResponse;
/**  
* DeleteFilesAPI.java - DELETE METHOD to delete files.  
* @author  Thirunavukkarasu v
* @version 1.0 
* @see DeleteFilesClass.java
*/
@Path("/deleteFiles")
public class DeleteFilesAPI {
	/**
	   *	Delete method for deleting the files  in database.
	   * 
	   * @param requires the input FilesModel class.
	   * @exception Any exception
	   * @return Which returns FilesResponse class.
	   */
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public FilesResponse deleteFiles(FilesModel model){
	return DeleteFilesClass.deleteFiles(model);
}
}
