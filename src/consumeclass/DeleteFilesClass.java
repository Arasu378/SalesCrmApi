package consumeclass;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.FilesModel;
import response.FilesResponse;
import utils.Constants;

public class DeleteFilesClass {
public static FilesResponse deleteFiles(FilesModel model){
	FilesResponse response=new FilesResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try{
			String query="{CALL  `UserSettings.Files_DeleteFiles`(?) }";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callableStatement=connection.prepareCall(query);
			int userProfileId=model.getUserProfileId();
			int fileId=model.getFileId();
			callableStatement.setInt(1, fileId);
			
			
			int count = callableStatement.executeUpdate();
			if(count>0){
				response=(GetFilesByUserProfileIdClass.getFilesByUserProfileId(userProfileId));
			}else{
				response.setIsSuccess(false);
				response.setMessage("File is not deleted");
				response.setFilesList(null);
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
			if(callableStatement!=null){
				try{
					callableStatement.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	
	return response;
}
}
