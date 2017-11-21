package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteNotesByNoteIdClass;
import model.NotesModel;
import response.NotesResponse;

@Path("/deleteNote")
public class DeleteNoteIdAPI {
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public NotesResponse deleteNote(NotesModel model){
	return DeleteNotesByNoteIdClass.deleteNote(model);
}
}
