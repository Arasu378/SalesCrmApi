package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import dbconstants.CompanyDBConstants;
import dbconstants.PipeLineDBConstants;
import response.PipeLineResponse;
import model.CompanyModel;
import model.PipeLineModel;

public class GetPipeLineByUserProfileIdClass {
	private static ArrayList<PipeLineModel>pipeLineList=new ArrayList<PipeLineModel>();
	public static PipeLineResponse getPipeLine(int UserProfileId){
		PipeLineResponse response=new PipeLineResponse();
		pipeLineList.clear();
		Connection connection=null;
		Statement st=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			String query="CALL `Settings.PipeLine_GetPipeLineByUserProfileId`("+UserProfileId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(utils.Constants.URL,utils.Constants.USER,utils.Constants.PASSWORD);
			st=connection.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
				 PipeLineModel pipModel=new PipeLineModel();
				 int pipeLineId=rs.getInt(PipeLineDBConstants.PIPE_LINE_ID);
				 pipModel.setPipeLineId(pipeLineId);
				 int userProfileId=rs.getInt(PipeLineDBConstants.USER_PROFILE_ID);
				 pipModel.setUserProfileId(userProfileId);
				 String name=rs.getString(PipeLineDBConstants.NAME);
				 if(name==null){
					 name="";
				 }
				 pipModel.setName(name);
				 String dateCreated=rs.getString(PipeLineDBConstants.DATE_CREATED);
				 if(dateCreated==null){
					 dateCreated="";
				 }
				 pipModel.setDateCreated(dateCreated);
				 String dateModified=rs.getString(PipeLineDBConstants.DATE_MODIFIED);
				 if(dateModified==null){
					 dateModified="";
				 }
				 pipModel.setDateModified(dateModified);
				 int orderNr=rs.getInt(PipeLineDBConstants.ORDER_NR);
				 pipModel.setOrderNr(orderNr);
				 boolean active=rs.getBoolean(PipeLineDBConstants.ACTIVE);
				 pipModel.setIsActive(active);
				 boolean selected=rs.getBoolean(PipeLineDBConstants.SELECTED);
				 pipModel.setIsSelected(selected);
				 boolean dealProbability=rs.getBoolean(PipeLineDBConstants.DEAL_PROBABILITY);
				 pipModel.setIsDealProbability(dealProbability);
				 String urlTitle=rs.getString(PipeLineDBConstants.URL_TITLE);
				 if(urlTitle==null){
					 urlTitle="";
					 
				 }
				 pipModel.setUrlTitle(urlTitle);
				 pipeLineList.add(pipModel);
			}
			 if(pipeLineList!=null&&pipeLineList.size()!=0){
				   response.setIsSuccess(true);
				   response.setMessage("");
				   response.setPipeLineList(pipeLineList);
			   }else{
				   response.setIsSuccess(false);
				   response.setMessage("PipeLine List is Empty or Null!");
				   response.setPipeLineList(null);
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
