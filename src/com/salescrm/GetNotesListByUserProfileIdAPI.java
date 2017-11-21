package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetNotesListByUserProfileIdClass;
import response.NotesResponse;

@Path("/getNotesListByUserProfileId/{UserProfileId}")
public class GetNotesListByUserProfileIdAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public NotesResponse getNotesList(@PathParam("UserProfileId")int UserProfileId){
	return GetNotesListByUserProfileIdClass.getNotesListByUserProfileId(UserProfileId);
}
}
