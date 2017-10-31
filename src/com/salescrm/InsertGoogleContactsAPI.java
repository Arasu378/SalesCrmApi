package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertGoogleContactsClass;
import model.GoogleContactsModel;
import response.GoogleContactsResponse;

@Path("/insertGoogleContacts")
public class InsertGoogleContactsAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public GoogleContactsResponse insertGoogleContacts(GoogleContactsModel model){
	return InsertGoogleContactsClass.insertGoogleContacts(model);
}
}
