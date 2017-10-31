package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.StagesModel;
import response.StagesResponse;
import utils.Constants;

public class UpdateStagesClass {
public static StagesResponse updateStages(StagesModel model){
	StagesResponse response=new StagesResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="{CALL `Settings.Stages_UpdateStages`(?,?,?,?,?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		int userProfileId=model.getUserProfileId();
		int stateId=model.getStageId();
		String name=model.getName();
		boolean rotten=model.getRotten();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 System.out.println(dateFormat.format(date));
		 String dateModified=dateFormat.format(date);
		 int orderNr=model.getOrderNr();
		 boolean activeFlag=model.getActiveFlag();
		 boolean dealProbability=model.getDealProbability();
		 boolean rottenFlag=model.getRottenFlag();
		 String rottenDays=model.getRottenDays();
		 String pipeLineName=model.getPipeLineName();
		 
		 connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		callableStatement.setInt(1,stateId );
		callableStatement.setString(2, name);
		callableStatement.setBoolean(3, rotten);
		callableStatement.setString(4, dateModified);
		callableStatement.setInt(5,orderNr );
		callableStatement.setBoolean(6, activeFlag);
		callableStatement.setBoolean(7, dealProbability);
		callableStatement.setBoolean(8, rottenFlag);
		callableStatement.setString(9, rottenDays);
		callableStatement.setString(10, pipeLineName);
		int count = callableStatement.executeUpdate();
		if(count>0){
			response=GetStagesByUserProfileIdClass.getStages(userProfileId);
			
		}else{
			response.setIsSuccess(false);
			response.setMessage("Stages is not updated");
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
