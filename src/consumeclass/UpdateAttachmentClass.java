package consumeclass;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.io.ByteStreams;

import response.AttachmentResponse;
import utils.Constants;

public class UpdateAttachmentClass {
	public static AttachmentResponse updateAttachment(int inputattachmentid, String attachmentFileName,String contentType, String fileSource,byte[] fileInputStream){
		byte[] valueinputstream = null;

		AttachmentResponse response =new AttachmentResponse();
	
		 Connection connection=null;
	 		CallableStatement callstatement=null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				 Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String query="{CALL `Company.usp_UpdateAttachment`(?,?,?,?,?,?)}";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				callstatement = connection.prepareCall(query);
				callstatement.setInt(1, inputattachmentid);
				callstatement.setString(2,attachmentFileName );
				callstatement.setString(3, contentType);
				callstatement.setString(4, fileSource);
				
					InputStream myInputStream = new ByteArrayInputStream(fileInputStream); 
					try {
						System.out.println("Is available : "+myInputStream.available());
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}

				callstatement.setBinaryStream(5, myInputStream);
				callstatement.setString(6, dateFormat.format(date));
				//callstatement.execute();
				int count = callstatement.executeUpdate();
				if(count>0){
					response.setIsSuccess(true);
					response.setMessage("Attachment updated Successfully");
					response.setAttachmentList(null);
				}else{
					response.setIsSuccess(false);
					response.setMessage("Attachment is not updated or AttachmentId is not existed");
					response.setAttachmentList(null);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(connection!=null){
					try{
						connection.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				if(callstatement!=null){
					try{
						callstatement.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		return response;
		
	}

}
