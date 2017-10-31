package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertNoteClass;
import model.NotesModel;
import response.NotesResponse;

@Path("/insertNote")
public class InsertNoteAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public NotesResponse insertNote(NotesModel model){
	return InsertNoteClass.insertNote(model);
}
}
