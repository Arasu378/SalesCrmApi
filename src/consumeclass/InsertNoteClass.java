package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dbconstants.OrganizationDBConstants;
import model.NotesModel;
import response.NotesResponse;
import utils.Constants;

public class InsertNoteClass {
public static NotesResponse insertNote(NotesModel model){
	NotesResponse response=new NotesResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	Statement st=null;
	int finalvalue=0;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		int userProfileId=model.getUserProfileId();
		int dealId=model.getDealId();
		int personId=model.getPersonId();
		int orgId=model.getOrgId();
		String content=model.getContent();
		content="'"+content+"'";
		boolean activeFlag=model.getActiveFlag();
		int companyId=model.getCompanyId();
		
		String query="CALL `UserSettings.Notes_InsertNotes`("+userProfileId+","+dealId+","+personId+","+orgId+","+content+","+activeFlag+","+companyId+")";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		//callableStatement=connection.prepareCall(query);
		st=connection.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()){
			 finalvalue=rs.getInt(OrganizationDBConstants.LAST_INSERT_ID);
		}
		
		 
		//int count=callableStatement.executeUpdate();
		//if(count>0){
		//response=GetNotesListByUserProfileIdClass.getNotesListByUserProfileId(userProfileId);
			if(finalvalue!=0){
				response.setIsSuccess(true);
				response.setMessage("");
				response.setId(finalvalue);
				response.setNotesList(null);
			}else{
				response.setIsSuccess(false);
				response.setMessage("Note id cannot be retrieved!");
				response.setNotesList(null);
			}
			
		//}else{
//			response.setIsSuccess(false);
//			response.setMessage("Notes insert is not successfull");
//			response.setNotesList(null);
		//}
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
