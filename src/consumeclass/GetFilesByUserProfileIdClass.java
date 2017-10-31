package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dbconstants.FilesDBConstants;
import model.FilesModel;
import response.FilesResponse;
import utils.Constants;

public class GetFilesByUserProfileIdClass {
	private static ArrayList<FilesModel>filesList=new ArrayList<FilesModel>();
	public static FilesResponse getFilesByUserProfileId(int UserProfileId){
		FilesResponse response=new FilesResponse();
		Connection connection=null;
		Statement st=null;
		filesList.clear();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="CALL `UserSettings.Files_GetFilesByUserProfileId`("+UserProfileId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			st=connection.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
				FilesModel model=new FilesModel();
				int fileId=rs.getInt(FilesDBConstants.FILE_ID);
				model.setFileId(fileId);
				int userProfileId=rs.getInt(FilesDBConstants.USER_PROFILE_ID);
				model.setUserProfileId(userProfileId);
				int dealId=rs.getInt(FilesDBConstants.DEAL_ID);
				model.setDealId(dealId);
				int personId=rs.getInt(FilesDBConstants.PERSON_ID);
				model.setPersonId(personId);
				int orgId=rs.getInt(FilesDBConstants.ORG_ID);
				model.setOrgId(orgId);
				int productId=rs.getInt(FilesDBConstants.PRODUCT_ID);
				model.setProductId(productId);
				int emailMessageId=rs.getInt(FilesDBConstants.EMAIL_MESSAGE_ID);
				model.setEmailMessageId(emailMessageId);
				int activityId=rs.getInt(FilesDBConstants.ACTIVITY_ID);
				model.setActivityId(activityId);
				int noteId=rs.getInt(FilesDBConstants.NOTE_ID);
				model.setNoteId(noteId);
				int logId=rs.getInt(FilesDBConstants.LOG_ID);
				model.setLogId(logId);
				String dateCreated=rs.getString(FilesDBConstants.DATE_CREATED);
				if(dateCreated==null){
					dateCreated="";
				}
				model.setDateCreated(dateCreated);
				String dateModified=rs.getString(FilesDBConstants.DATE_MODIFIED);
				if(dateModified==null){
					dateModified="";
				}
				model.setDateModified(dateModified);
				String fileName=rs.getString(FilesDBConstants.FILE_NAME);
				if(fileName==null){
					fileName="";
				}
				model.setFileName(fileName);
				String fileType=rs.getString(FilesDBConstants.FILE_TYPE);
				if(fileType==null){
					fileType="";
				}
				model.setFileType(fileType);
				int  fileSize=rs.getInt(FilesDBConstants.FILE_SIZE);
				model.setFileSize(String.valueOf(fileSize));
				boolean activeFlag=rs.getBoolean(FilesDBConstants.ACTIVE_FLAG);
				model.setActiveFlag(activeFlag);
				boolean inLineFlag=rs.getBoolean(FilesDBConstants.IN_LINE_FLAG);
				model.setInLineFlag(inLineFlag);
				String remoteLocation=rs.getString(FilesDBConstants.REMOTE_LOCATION);
				if(remoteLocation==null){
					remoteLocation="";
				}
				model.setRemoteLocation(remoteLocation);
				int remoteId=rs.getInt(FilesDBConstants.REMOTE_ID);
				
				model.setRemoteId((remoteId));
				String cid=rs.getString(FilesDBConstants.CID);
				if(cid==null){
					cid="";
				}
				model.setCid(cid);
				String sBucket=rs.getString(FilesDBConstants.S_BUCKET);
				if(sBucket==null){
					sBucket="";
				}
				model.setsBucket(sBucket);
				int mailMessageId=rs.getInt(FilesDBConstants.MAIL_MESSAGE_ID);
				model.setMailMessageId(String.valueOf(mailMessageId));
				String dealName=rs.getString(FilesDBConstants.DEAL_NAME);
				if(dealName==null){
					dealName="";
				}
				model.setDealName(dealName);
				String personName=rs.getString(FilesDBConstants.PERSON_NAME);
				if(personName==null){
					personName="";
				}
				model.setPersonName(personName);
				String uRL=rs.getString(FilesDBConstants.URL);
				if(uRL==null){
					uRL="";
				}
				model.setuRL(uRL);
				String name=rs.getString(FilesDBConstants.NAME);
				if(name==null){
					name="";
				}
				model.setName(name);
				String description=rs.getString(FilesDBConstants.DESCRIPTION);
				if(description==null){
					description="";
				}
				model.setDescription(description);
				filesList.add(model);
				
			}
			if(filesList!=null && filesList.size()!=0){
				response.setIsSuccess(true);
				response.setMessage("");
				response.setFilesList(filesList);
			}else{
				response.setIsSuccess(false);
				response.setMessage("Files List is empty or null");
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
			if(st!=null){
				try {
					st.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		return response;
	}

}
