package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import response.NotesResponse;
import consumeclass.GetNotesListByNoteIdClass;

@Path("/getNotesListByNoteId/{NoteId}")
public class GetNoteListByNoteIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public NotesResponse getNotesList(@PathParam("NoteId")int NoteId){
	return GetNotesListByNoteIdClass.getNotesListByNoteId(NoteId);
}
}
