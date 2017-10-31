package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.FilesModel;
import response.FilesResponse;
import utils.Constants;

public class UpdateFilesClass {
public static FilesResponse updateFile(FilesModel model){
	FilesResponse response=new FilesResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="{CALL  `UserSettings.Files_UpdateFiles`(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		int userProfileId=model.getUserProfileId();
		int dealId=model.getDealId();
		callableStatement.setInt(1, dealId);
		int personId=model.getPersonId();
		callableStatement.setInt(2, personId);
		int orgId=model.getOrgId();
		callableStatement.setInt(3, orgId);
		int productId=model.getProductId();
		callableStatement.setInt(4, productId);
		int emailMessageId=model.getEmailMessageId();
		callableStatement.setInt(5, emailMessageId);
		int activityId=model.getActivityId();
		callableStatement.setInt(6, activityId);
		int noteId=model.getNoteId();
		callableStatement.setInt(7, noteId);
		int logId=model.getLogId();
		callableStatement.setInt(8, logId);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 String dateModified=dateFormat.format(date);
			callableStatement.setString(9, dateModified);
		 String fileName=model.getFileName();
			callableStatement.setString(10, fileName);
		 String fileType=model.getFileType();
			callableStatement.setString(11, fileType);
		 String fileSize=model.getFileSize();
			callableStatement.setString(12, fileSize);
		 boolean inLineFlag=model.getInLineFlag();
			callableStatement.setBoolean(13, inLineFlag);
		 String remoteLocation=model.getRemoteLocation();
			callableStatement.setString(14, remoteLocation);
		 int remoteId=model.getRemoteId();
			callableStatement.setInt(15, remoteId);
		 String cid=model.getCid();
			callableStatement.setString(16, cid);
		 String sBucket=model.getsBucket();
			callableStatement.setString(17, sBucket);
		 String mailMessageId=model.getMailMessageId();
			callableStatement.setString(18, mailMessageId);
		 String dealName=model.getDealName();
			callableStatement.setString(19, dealName);
		 String personName=model.getPersonName();
			callableStatement.setString(20, personName);
		 String orgName=model.getOrgName();
			callableStatement.setString(21, orgName);
		 String productName=model.getProductName();
			callableStatement.setString(22, productName);
		 String url=model.getuRL();
			callableStatement.setString(23, url);
		 String name=model.getName();
			callableStatement.setString(24, name);
		 String description=model.getDescription();
			callableStatement.setString(25, description);
		 int fileId=model.getFileId();
			callableStatement.setInt(26, fileId);
		int count = callableStatement.executeUpdate();
		if(count>0){
			response=GetFilesByUserProfileIdClass.getFilesByUserProfileId(userProfileId);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Files is not updated!");
			response.setFilesList(null);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(connection!=null){
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(callableStatement!=null){
			try {
				callableStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	return response;
}
}
