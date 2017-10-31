package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteAttachmentClass;
import response.AttachmentResponse;

@Path("/deleteAttachment/{AttachmentId}")
public class DeleteAttachmentApi {
@GET
@Produces(MediaType.APPLICATION_JSON)
public AttachmentResponse deleteAttachment(@PathParam ("AttachmentId")int attachmentid){
	return DeleteAttachmentClass.deleteAttachment(attachmentid);
}
}
