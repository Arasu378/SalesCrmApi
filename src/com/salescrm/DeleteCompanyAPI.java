package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

import consumeclass.DeleteAttachmentClass;
import consumeclass.DeleteCompanyClass;
import model.CompanyModel;
import response.CompanyResponse;
/**  
* DeleteCompanyAPI.java - DELETE METHOD to delete company.  
* @author  Thirunavukkarasu v
* @version 1.0 
* @see DeleteCompanyClass.java
*/
@Path("/deleteCompany")
public class DeleteCompanyAPI {
	/**
	   *	Delete method for deleting the company in database.
	   * 
	   * @param requires the input CompanyModel class.
	   * @exception Any exception
	   * @return Which returns CompanyResponse class.
	   */
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public CompanyResponse deleteCompany(CompanyModel model){
	return DeleteCompanyClass.deleteCompany(model);
}
}
