package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import com.google.common.util.concurrent.Callables;

import model.StagesModel;
import response.StagesResponse;
import utils.Constants;

public class InsertStagesClass {
public static StagesResponse insertStages(StagesModel model){
	StagesResponse response=new StagesResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="{CALL  `Settings.Stages_InsertStages`(?,?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		int userProfileId=model.getUserProfileId();
		int pipeLineId=model.getPipeLineId();
		String name=model.getName();
		boolean rotten=model.getRotten();
		boolean activeFlag=model.getActiveFlag();
		boolean dealProbability=model.getDealProbability();
		String pipeLineName=model.getPipeLineName();
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		callableStatement.setInt(1,userProfileId );
		callableStatement.setInt(2,pipeLineId );
		callableStatement.setString(3, name);
		callableStatement.setBoolean(4, rotten);
		callableStatement.setBoolean(5, activeFlag);
		callableStatement.setBoolean(6, dealProbability);
		callableStatement.setString(7, pipeLineName);

		int count = callableStatement.executeUpdate();
		if(count>0){
			response=GetStagesByUserProfileIdClass.getStages(userProfileId);
			
		}else{
			response.setIsSuccess(false);
			response.setMessage("Stages is not inserted");
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
