package com.salescrm;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetAttachmentPictureByAttachmentIdClass;

@Path("/getAttachmentPicture/{AttachmentId}")
public class GetAttachmentPictureByAttachmentIdAPI {
	@GET
	@Produces("image/jpeg")
	public InputStream getAttachmentPicture(@PathParam("AttachmentId")int AttachmentId){
		return GetAttachmentPictureByAttachmentIdClass.getPictures(AttachmentId);
	}

}
