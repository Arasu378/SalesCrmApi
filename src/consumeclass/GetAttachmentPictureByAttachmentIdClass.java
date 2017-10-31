package consumeclass;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;



import dbconstants.AttachmentsDBConstants;
import utils.Constants;

public class GetAttachmentPictureByAttachmentIdClass {
public static InputStream getPictures(int AttachmentId){
	Connection connection=null;
	byte[] pictureByte=null;
	ByteArrayInputStream bis=null ;
	Blob blob=null;
	 
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="CALL `SalesCrm.Attachment_GetPicturebyAttachmentId`("+AttachmentId+");";
		System.out.println("query: "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		java.sql.Statement st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   if(rs.next()){
			   blob=rs.getBlob(AttachmentsDBConstants.FILE_BINARY);
			   InputStream binarystream=blob.getBinaryStream(1,blob.length());
				  return binarystream;
			   
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
	}
	return  bis;
}
}
