package com.salescrm;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetAttachmentByAttachmentIdClass;
import response.AttachmentResponse;
import javax.ws.rs.GET;

@Path("/getAttachmentId/{AttachmentId}")
public class GetAttachmentByAttachmentIdAPI {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public AttachmentResponse getAttachment(@PathParam("AttachmentId")int AttachmentId){
		return GetAttachmentByAttachmentIdClass.getAttachment(AttachmentId);
	}

}
