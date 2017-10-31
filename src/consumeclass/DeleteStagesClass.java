package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import model.StagesModel;
import response.StagesResponse;
import utils.Constants;

public class DeleteStagesClass {
	public static StagesResponse deleteStage(StagesModel model){
		StagesResponse response=new StagesResponse();
		Connection connection=null;
		CallableStatement statement=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		int stageId=model.getStageId();
		int userProfileId=model.getUserProfileId();
		try{
			String query="{CALL `Settings.Stages_DeleteStage`(?)}";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			statement=connection.prepareCall(query);
			statement.setInt(1, stageId);
			int count = statement.executeUpdate();
			if(count>0){
				response=GetStagesByUserProfileIdClass.getStages(userProfileId);
				
			}else{
				response.setIsSuccess(false);
				response.setMessage("Stages is not deleted");
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
