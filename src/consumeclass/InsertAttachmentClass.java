package consumeclass;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import response.AttachmentResponse;
import utils.Constants;

public class InsertAttachmentClass {
	public static AttachmentResponse insertAttachment(String attachmentFileName,String contentType, String fileSource,byte[] fileInputStream){
		AttachmentResponse response=new AttachmentResponse();
		 Connection connection=null;
	 		CallableStatement callstatement=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				
		 		String query="{CALL `Company.usp_InsertAttachment`(?,?,?,?)}";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				callstatement = connection.prepareCall(query);
				callstatement.setString(1,attachmentFileName );
				callstatement.setString(2, contentType);
				callstatement.setString(3, fileSource);
				InputStream myInputStream = new ByteArrayInputStream(fileInputStream); 

				callstatement.setBinaryStream(4, myInputStream);
			//	callstatement.execute();
				int count = callstatement.executeUpdate();
				if(count>0){
					response.setIsSuccess(true);
					response.setMessage("Attachment inserted Successfully");
					response.setAttachmentList(null);
				}else{
					response.setIsSuccess(false);
					response.setMessage("Attachment is not inserted");
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
