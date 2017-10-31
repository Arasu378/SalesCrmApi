package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.NotesModel;
import response.NotesResponse;
import utils.Constants;

public class UpdateNotesClass {
public static NotesResponse updateNote(NotesModel model){
	NotesResponse response=new NotesResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="{CALL `UserSettings.Notes_UpdateNotes`(?,?,?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		int userProfileId=model.getUserProfileId();
		String content=model.getContent();
		callableStatement.setString(1, content);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 String dateModified=dateFormat.format(date);
		 callableStatement.setString(2, dateModified);
		 boolean activeFlag=model.getActiveFlag();
		 callableStatement.setBoolean(3, activeFlag);
		 boolean pinnedToDealFlag=model.getPinnedToDealFlag();
		 callableStatement.setBoolean(4, pinnedToDealFlag);
		 boolean pinnedToPersonFlag=model.getPinnedToPersonFlag();
		 callableStatement.setBoolean(5, pinnedToPersonFlag);
		 boolean pinnedToOrganizationFlag=model.getPinnedToOrganizationFlag();
		 callableStatement.setBoolean(6, pinnedToOrganizationFlag);
		 int lastUpdateUserId=model.getLastUpdateUserId();
		 callableStatement.setInt(7, lastUpdateUserId);
		 int noteId=model.getNoteId();
		 callableStatement.setInt(8, noteId);
		
		int count=callableStatement.executeUpdate();
		if(count>0){
			response=GetNotesListByUserProfileIdClass.getNotesListByUserProfileId(userProfileId);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Notes not updated"+count);
			response.setNotesList(null);
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
