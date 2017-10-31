package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.google.common.io.Files;

import dbconstants.AttachmentsDBConstants;
import model.AttachmentModel;
import response.AttachmentResponse;
import utils.Constants;

public class GetAttachmentByAttachmentIdClass {
	private static ArrayList<AttachmentModel>attachmentList=new ArrayList<AttachmentModel>();
public static AttachmentResponse getAttachment(int AttachmentId){
	AttachmentResponse response=new AttachmentResponse();
	attachmentList.clear();
	 Connection connection=null;
	 java.sql.Statement st=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="CALL `SalesCrm.Attachment_GetAttachmentbyAttachmentId`("+AttachmentId+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   
		   while(rs.next()){
			   AttachmentModel model=new AttachmentModel();
			   int attachmentId=rs.getInt(AttachmentsDBConstants.ATTACHMENT_ID);
			   String attachmentFileName=rs.getString(AttachmentsDBConstants.ATTACHMENT_FILE_NAME);
			   if(attachmentFileName==null){
				   attachmentFileName="";
			   }
			   String contentType=rs.getString(AttachmentsDBConstants.CONTENT_TYPE);
			   if(contentType==null){
				  contentType="";
			   }
			   String fileSource=rs.getString(AttachmentsDBConstants.FILE_SOURCE);
			   if(fileSource==null){
				   fileSource="";
			   }
			   String attachedOn=rs.getString(AttachmentsDBConstants.ATTACHED_ON);
			   if(attachedOn==null){
				   attachedOn="";
			   }
			   String pictureUrl=Constants.PICTURE_URL+AttachmentId;
			   model.setAttachmentId(attachmentId);
			   model.setAttachmentFileName(attachmentFileName);
			   model.setContentType(contentType);
			   model.setFileSource(fileSource);
			   model.setAttachedOn(attachedOn);
			   model.setPictureUrl(pictureUrl);
			   attachmentList.add(model);
			   if(attachmentList!=null &&attachmentList.size()!=0){
				   response.setIsSuccess(true);
				   response.setMessage("");
				   response.setAttachmentList(attachmentList);
			   }else{
				   response.setIsSuccess(false);
				   response.setMessage("List is empty or null");
				   response.setAttachmentList(null);
			   }
			   
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
		if(st!=null){
			try{
				st.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	return response;
}
}
