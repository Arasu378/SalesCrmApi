package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.NotesModel;
import response.NotesResponse;
import utils.Constants;

public class DeleteNotesByNoteIdClass {
public static NotesResponse deleteNote(NotesModel model){
	NotesResponse response=new NotesResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="{CALLL `UserSettings.Notes_DeleteNote`(?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		int userProfileId=model.getUserProfileId();
		int noteId=model.getNoteId();
		callableStatement.setInt(1, noteId);
		int count=callableStatement.executeUpdate();
		if(count>0){
			response=GetNotesListByUserProfileIdClass.getNotesListByUserProfileId(userProfileId);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Note is not deleted");
			response.setNotesList(null);
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
