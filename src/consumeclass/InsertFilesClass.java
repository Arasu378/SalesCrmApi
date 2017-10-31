package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.FilesModel;
import response.FilesResponse;
import utils.Constants;

public class InsertFilesClass {
public static FilesResponse insertFile(FilesModel model){
	FilesResponse response=new FilesResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="{CALL `UserSettings.Files_InsertFiles`(?,?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		int userProfileId=model.getUserProfileId();
		callableStatement.setInt(1,userProfileId);
		int orgId=model.getOrgId();
		callableStatement.setInt(2,orgId);
		String fileName=model.getFileName();
		callableStatement.setString(3,fileName);
		String fileType=model.getFileType();
		callableStatement.setString(4,fileType);
		boolean activeFlag=model.getActiveFlag();
		callableStatement.setBoolean(5,activeFlag);
		int remoteId=model.getRemoteId();
		callableStatement.setInt(6,remoteId);
		String orgName=model.getOrgName();
		callableStatement.setString(7,orgName);

		
		int count = callableStatement.executeUpdate();
		if(count>0){
			response=GetFilesByUserProfileIdClass.getFilesByUserProfileId(userProfileId);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Files is not inserted");
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
