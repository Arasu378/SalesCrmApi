package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.NotesModel;
import response.NotesResponse;
import utils.Constants;

public class InsertNoteClass {
public static NotesResponse insertNote(NotesModel model){
	NotesResponse response=new NotesResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="{CALL `UserSettings.Notes_InsertNotes`(?,?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		int userProfileId=model.getUserProfileId();
		callableStatement.setInt(1, userProfileId);
		int dealId=model.getDealId();
		callableStatement.setInt(2, dealId);
		int personId=model.getPersonId();
		callableStatement.setInt(3, personId);
		int orgId=model.getOrgId();
		callableStatement.setInt(4, orgId);
		String content=model.getContent();
		callableStatement.setString(5, content);
		boolean activeFlag=model.getActiveFlag();
		callableStatement.setBoolean(6, activeFlag);
		int companyId=model.getCompanyId();
		callableStatement.setInt(7, companyId);
		 
		int count=callableStatement.executeUpdate();
		if(count>0){
			response=GetNotesListByUserProfileIdClass.getNotesListByUserProfileId(userProfileId);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Notes insert is not successfull");
			response.setNotesList(null);
		}
		}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(connection!=null){
			try {
				connection.close();
			} catch (Exception e) {
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
