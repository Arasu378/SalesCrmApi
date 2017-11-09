package com.salescrm;
/**  
* DeleteIndustryTypeAPI.java - DELETE METHOD to delete industry type  data.  
* @author  Thirunavukkarasu v
* @version 1.0 
* @see DeleteIndustryTypeClass.java
*/
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteGoogleDriveClass;
import consumeclass.DeleteIndustryTypeClass;
import model.IndustryTypeModel;
import response.IndustryTypeResponse;

@Path("/deleteIndustryType")
public class DeleteIndustryTypeAPI {
	/**
	   *	Delete method for deleting the industry type data  in database.
	   * 
	   * @param requires the input IndustryTypeModel.java class.
	   * @exception Any exception
	   * @return Which returns IndustryTypeResponse.java class.
	   */
@DELETE
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public IndustryTypeResponse deleteData(IndustryTypeModel model){
	return DeleteIndustryTypeClass.deleteIndustryType(model);
}
}
