package test;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Assert;
import org.junit.Test;

import response.AttachmentResponse;
import utils.AndroidMultiPartEntity;
import consumeclass.DeleteAttachmentClass;
import consumeclass.GetAttachmentByAttachmentIdClass;
import consumeclass.InsertAttachmentClass;
import consumeclass.UpdateAttachmentClass;

public class AttachmentUnitTest {
	@Test
public void TestGetAttachmentByAttachmentIdSuccess(){
		
	AttachmentResponse value=GetAttachmentByAttachmentIdClass.getAttachment(100001);
	      assertEquals("message", value.getIsSuccess(),true);

	}
	@Test
	public void TestGetAttachmentByAttachmentIdTestSuccess(){
			
		AttachmentResponse value=GetAttachmentByAttachmentIdClass.getAttachment(100001);
		      assertEquals("message", value.getAttachmentList().get(0).getAttachmentId(),100001);

		}
	@Test
	public void TestGetAttachmentByAttachmentIdFailure(){
		
	AttachmentResponse value=GetAttachmentByAttachmentIdClass.getAttachment(1);
	      assertEquals("message", value.getIsSuccess(),false);
	}
@Test	
public void updateAttachment(){
	byte[] image=null;
	try {
		 image=extractBytes("C:/Users/kyros/Pictures/railway.PNG");
	} catch (IOException e) {
		e.printStackTrace();
	}
	  int ids=  image.length;
      System.out.println("image length : "+ids);
	InputStream myInputStream = new ByteArrayInputStream(image); 
	AttachmentResponse rs=UpdateAttachmentClass.updateAttachment(100001, "railway", "png",  "png logo", image);
//boolean value=updateAttachment(100001, "Test file name", "png", "png image", image);
assertEquals("update attachment", rs.getIsSuccess(), true);


}
@Test
public void insertAttachment(){
	byte[] image=null;
	try {
		 image=extractBytes("C:/Users/kyros/Pictures/railway_logo.png");
	} catch (IOException e) {
		e.printStackTrace();
	}
	AttachmentResponse res=InsertAttachmentClass.insertAttachment("Railway logo", "png", "railway", image);
	assertEquals("insert attachment", res.getIsSuccess(),true);
}
@Test
public void deleteAttachment(){
	AttachmentResponse res=DeleteAttachmentClass.deleteAttachment(100004);
	assertEquals("delete attachment", res.getIsSuccess(),true);
}
public byte[] extractBytes (String ImageName) throws IOException {
	 // open image
	File fnew=new File(ImageName);
	BufferedImage originalImage=ImageIO.read(fnew);
	ByteArrayOutputStream baos=new ByteArrayOutputStream();
	ImageIO.write(originalImage, "jpg", baos );
	byte[] imageInByte=baos.toByteArray();
	 return imageInByte;
	}


}
