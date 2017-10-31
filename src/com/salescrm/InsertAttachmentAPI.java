package com.salescrm;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;

import com.google.common.io.ByteStreams;

import consumeclass.InsertAttachmentClass;
import response.AttachmentResponse;

@Path("/insertAttachment")
public class InsertAttachmentAPI {
	@POST
    @Consumes(value={MediaType.MULTIPART_FORM_DATA})
 @Produces(MediaType.APPLICATION_JSON)
	public AttachmentResponse insertData(
            @FormDataParam("AttachmentFileName")String attachmentFileName,
            @FormDataParam("ContentType")String contentType,
            @FormDataParam("FileSource")String fileSource,
            @FormDataParam("FileBinary") InputStream fileInputStream){
		byte[] valueinputstream=null;
		 try{
	            valueinputstream= ByteStreams.toByteArray(fileInputStream);

	        }catch(Exception e){
	        	e.printStackTrace();
	        }
		return InsertAttachmentClass.insertAttachment(attachmentFileName, contentType, fileSource, valueinputstream);
	}
}
