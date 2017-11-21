package com.salescrm;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;

import com.google.common.io.ByteStreams;

import response.AttachmentResponse;
import consumeclass.UpdateAttachmentClass;

@Path("/updateAttachment")
public class UpdateAttachmentAPI {
	@PUT
	@Secured
    @Consumes(value={MediaType.MULTIPART_FORM_DATA})
 @Produces(MediaType.APPLICATION_JSON)
	public AttachmentResponse insertData( @FormDataParam("AttachmentId")int inputattachmentid,
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

		try {
			int is=fileInputStream.available();
			System.out.println("Is available : "+is);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return UpdateAttachmentClass.updateAttachment(inputattachmentid, attachmentFileName, contentType, fileSource, valueinputstream );
	}
}
