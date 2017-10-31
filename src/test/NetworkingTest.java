package test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

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

import utils.AndroidMultiPartEntity;

/**
 * @author kyros
 *
 */
public class NetworkingTest {
	
	
	public static void main(String[] args) {
		byte[] image=null;
		try {
			 image=extractBytes("C:/Users/kyros/Pictures/railway.PNG");
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean value=updateAttachment(100001, "Test file name", "png", "png image", image);

	}
	public static byte[] extractBytes (String ImageName) throws IOException {
		 // open image
		File fnew=new File(ImageName);
		BufferedImage originalImage=ImageIO.read(fnew);
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		ImageIO.write(originalImage, "jpg", baos );
		byte[] imageInByte=baos.toByteArray();
		 return imageInByte;
		}
	@SuppressWarnings({ "deprecation" })
	private static boolean updateAttachment(int AttachmentId,String AttachmentFileName,String cType,String FileSource,byte[] bytearayProfile) {
	    String responseString = null;

	    int ids=  bytearayProfile.length;
	    System.out.println("Byte array profile length : "+ids);
	    HttpClient httpclient = new DefaultHttpClient();
	    String url = "http://192.168.0.111:8080/SalesCrmApi/v1/"+ "updateAttachment";
	   
	    
	    HttpPut httppost = new HttpPut(url);

	    try {
	        AndroidMultiPartEntity entity = new AndroidMultiPartEntity(
	                new AndroidMultiPartEntity.ProgressListener() {

	                    @Override
	                    public void transferred(long num) {
	                        //publishProgress((int) ((num / (float) totalSize) * 100));
	                    }
	                });

//	        File sourceFile = new File(filePath);

	        // Adding file data to http body

	        entity.addPart("FileBinary", new ByteArrayBody(bytearayProfile, "liq.jpg"));
	        entity.addPart("AttachmentId", new StringBody(String.valueOf(AttachmentId), ContentType.TEXT_PLAIN));
	        entity.addPart("AttachmentFileName", new StringBody(AttachmentFileName, ContentType.TEXT_PLAIN));
	        entity.addPart("ContentType", new StringBody(cType, ContentType.TEXT_PLAIN));
	        entity.addPart("FileSource", new StringBody(FileSource, ContentType.TEXT_PLAIN));


	        long totalSize = entity.getContentLength();
	        httppost.setEntity(entity);

	        // Making server call
	        HttpResponse response = httpclient.execute(httppost);
	        HttpEntity r_entity = response.getEntity();
	      

	        int statusCode = response.getStatusLine().getStatusCode();
	        if (statusCode == 200) {
	            System.out.println("Result : "+"Successfully updated");
	            return true;
	        } else {
	        	System.out.println("Expec else:  "+statusCode);

	            responseString = "Error occurred! Http Status Code: "
	                    + statusCode;
	            System.out.println("Result : "+"Not updated : "+responseString);
	return false;

	        }


	    } catch (ClientProtocolException e) {
	        responseString = e.toString();
	    	System.out.println("Expec client exception:  ");

	        return false;

	    } catch (IOException e) {
	        responseString = e.toString();
	    	System.out.println("IO exception:  "+e.toString());

	        return false;

	    }



	}

}
