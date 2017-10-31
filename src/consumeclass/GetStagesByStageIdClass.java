package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.StagesModel;
import response.StagesResponse;
import utils.Constants;
import dbconstants.StagesDBConstants;

public class GetStagesByStageIdClass {
	private static ArrayList<StagesModel>stagesList=new ArrayList<StagesModel>();
	public static StagesResponse getStagesByStageId(int StageId){
		StagesResponse response =new StagesResponse();
		Connection connection=null;
		Statement statement=null;
		stagesList.clear();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			String query="CALL `Settings.Stages_GetStageByStageId`("+StageId+")";
			System.out.println("Query: "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			statement=connection.createStatement();
			ResultSet rs=statement.executeQuery(query);
			while(rs.next()){
				StagesModel model=new StagesModel();
				int stageId=rs.getInt(StagesDBConstants.STAGES_ID);
				model.setStageId(stageId);
				int userProfileId=rs.getInt(StagesDBConstants.USER_PROFILE_ID);
				model.setUserProfileId(userProfileId);
				int pipeLineId=rs.getInt(StagesDBConstants.PIPE_LINE_ID);
				model.setPipeLineId(pipeLineId);
				String name=rs.getString(StagesDBConstants.NAME);
				if(name==null){
					name="";
				}
				model.setName(name);
				boolean rotten=rs.getBoolean(StagesDBConstants.ROTTEN);
				model.setRotten(rotten);
				String dateCreated=rs.getString(StagesDBConstants.DATE_CREATED);
				if(dateCreated==null){
					dateCreated="";
				}
				model.setDateCreated(dateCreated);
				String dateModified=rs.getString(StagesDBConstants.DATE_MODIFIED);
				if(dateModified==null){
					dateModified="";
				}
				model.setDateModified(dateModified);
				int orderNr=rs.getInt(StagesDBConstants.ORDER_NR);
				model.setOrderNr(orderNr);
				boolean activeFlag=rs.getBoolean(StagesDBConstants.ACTIVE_FLAG);
				model.setActiveFlag(activeFlag);
				boolean dealProbability=rs.getBoolean(StagesDBConstants.DEAL_PROBABILITY);
				model.setDealProbability(dealProbability);
				boolean rottenFlag=rs.getBoolean(StagesDBConstants.ROTTEN_FLAG);
				model.setRottenFlag(rottenFlag);
				String rottenDays=rs.getString(StagesDBConstants.ROTTEN_DAYS);
				if(rottenDays==null){
					rottenDays="";
				}
				model.setRottenDays(rottenDays);
				String pipeLineName=rs.getString(StagesDBConstants.PIPE_LINE_NAME);
				if(pipeLineName==null){
					pipeLineName="";
				}
				model.setPipeLineName(pipeLineName);
						stagesList.add(model);
			}
			if(stagesList!=null&&stagesList.size()!=0){
				 response.setIsSuccess(true);
				   response.setMessage("");
				   response.setStagesList(stagesList);
			   }else{
				   response.setIsSuccess(false);
				   response.setMessage("Stages List is Empty or Null!");
				   response.setStagesList(null);
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
			if(statement!=null){
				try{
					statement.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return response;
	}

}
