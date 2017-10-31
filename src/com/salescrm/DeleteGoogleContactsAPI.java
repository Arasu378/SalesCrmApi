package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

import consumeclass.DeleteGoogleContactsClass;
import model.GoogleContactsModel;
import response.GoogleContactsResponse;

@Path("/deleteGoogleContacts")
public class DeleteGoogleContactsAPI {
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public GoogleContactsResponse deleteGoogleContacts(GoogleContactsModel model){
	return DeleteGoogleContactsClass.deleteGoogleContacts(model);
}
}
