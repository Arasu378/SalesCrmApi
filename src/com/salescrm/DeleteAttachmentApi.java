package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteActivityTypeClass;
import consumeclass.DeleteAttachmentClass;
import response.AttachmentResponse;
/**  
* DeleteAttachmentApi.java - DELETE METHOD to delete Attachment.  
* @author  Thirunavukkarasu v
* @version 1.0 
* @see DeleteAttachmentClass.java
*/
@Path("/deleteAttachment/{AttachmentId}")
public class DeleteAttachmentApi {
	/**
	   *	Delete method for deleting the attachment in database.
	   * 
	   * @param requires the input integer AttachmentId.
	   * @exception Any exception
	   * @return Which returns AttachmentResponse class.
	   */
@GET
@Produces(MediaType.APPLICATION_JSON)
public AttachmentResponse deleteAttachment(@PathParam ("AttachmentId")int attachmentid){
	return DeleteAttachmentClass.deleteAttachment(attachmentid);
}
}
