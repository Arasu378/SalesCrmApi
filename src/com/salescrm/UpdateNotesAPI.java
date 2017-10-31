package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateNotesClass;
import model.NotesModel;
import response.NotesResponse;

@Path("/updateNotes")
public class UpdateNotesAPI {
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public NotesResponse updateNotes(NotesModel model){
	return UpdateNotesClass.updateNote(model);
}
}
