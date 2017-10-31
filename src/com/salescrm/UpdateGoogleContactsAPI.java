package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateGoogleContactsClass;
import model.GoogleContactsModel;
import response.GoogleContactsResponse;

@Path("/updateGoogleContacts")
public class UpdateGoogleContactsAPI {
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public GoogleContactsResponse updateGoogleContacts(GoogleContactsModel model){
	return UpdateGoogleContactsClass.updateGoogleContacts(model);
}
}
