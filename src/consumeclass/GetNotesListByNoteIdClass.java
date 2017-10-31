package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.NotesModel;
import response.NotesResponse;
import utils.Constants;
import dbconstants.NotesDBConstants;

public class GetNotesListByNoteIdClass {
	private static ArrayList<NotesModel>notesList=new ArrayList<NotesModel>();
	public static NotesResponse getNotesListByNoteId(int NoteId){
		NotesResponse response=new NotesResponse();
		Connection connection=null;
		Statement st=null;
		notesList.clear();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			String query="CALL `UserSettings.Notes_GetNotesByNoteId`("+NoteId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			st=connection.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
				NotesModel model=new NotesModel();
				int notesId=rs.getInt(NotesDBConstants.NOTE_ID);
				model.setNoteId(notesId);
				int userProfileId=rs.getInt(NotesDBConstants.USER_PROFILE_ID);
				model.setUserProfileId(userProfileId);
				int dealId=rs.getInt(NotesDBConstants.DEAL_ID);
				model.setDealId(dealId);
				int personId=rs.getInt(NotesDBConstants.PERSON_ID);
				model.setPersonId(personId);
				int orgId=rs.getInt(NotesDBConstants.ORG_ID);
				model.setOrgId(orgId);
				String content=rs.getString(NotesDBConstants.CONTENT);
				if(content==null){
					content="";
				}
				model.setContent(content);
				String dateCreated=rs.getString(NotesDBConstants.DATE_CREATED);
				if(dateCreated==null){
					dateCreated="";
				}
				model.setDateCreated(dateCreated);
				String dateModified=rs.getString(NotesDBConstants.DATE_MODIFIED);
				if(dateModified==null){
					dateModified="";
				}
				model.setDateModified(dateModified);
				boolean activeFlag=rs.getBoolean(NotesDBConstants.ACTIVE_FLAG);
				model.setActiveFlag(activeFlag);
				boolean pinnedToDealFlag=rs.getBoolean(NotesDBConstants.PINNED_TO_DEAL_FLAG);
				model.setPinnedToDealFlag(pinnedToDealFlag);
				boolean pinnedToPersonFlag=rs.getBoolean(NotesDBConstants.PINNED_TO_PERSON_FLAG);
				model.setPinnedToPersonFlag(pinnedToPersonFlag);
				boolean pinnedToOrganizationFlag=rs.getBoolean(NotesDBConstants.PINNED_TO_ORGANIZATION_FLAG);
				model.setPinnedToOrganizationFlag(pinnedToOrganizationFlag);
				int lastUpdateUserId=rs.getInt(NotesDBConstants.LAST_UPDATE_USER_ID);
				model.setLastUpdateUserId(lastUpdateUserId);
				int companyId=rs.getInt(NotesDBConstants.COMPANY_ID);
				model.setCompanyId(companyId);
				notesList.add(model);
			}
			if(notesList!=null && notesList.size()!=0){
				response.setIsSuccess(true);
				response.setMessage("");
				response.setNotesList(notesList);
			}else{
				response.setIsSuccess(false);
				response.setMessage("Notes List is empty or null");
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
