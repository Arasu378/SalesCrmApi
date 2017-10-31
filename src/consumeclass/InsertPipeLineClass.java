package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.PipeLineModel;
import response.PipeLineResponse;
import utils.Constants;

public class InsertPipeLineClass {
	public static PipeLineResponse insertPipeLine(PipeLineModel model){
		PipeLineResponse response=new PipeLineResponse();
		Connection connection=null;
		CallableStatement callableStatement=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			String query="{CALL `Settings.PipeLine_InsertPipeLine`(?,?,?,?)}";
			System.out.println("Query : "+query);
			String name=model.getName();
			int userProfileId=model.getUserProfileId();
			int orderNr=model.getOrderNr();
			boolean active=model.getIsActive();
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callableStatement = connection.prepareCall(query);
			callableStatement.setString(1,name );
			callableStatement.setInt(2, userProfileId);
			callableStatement.setInt(3, orderNr);
			callableStatement.setBoolean(4, active);
			int count = callableStatement.executeUpdate();
			if(count>0){
				response=(GetAllPipeLineClass.getPipeLine());
			}else{
				response.setIsSuccess(false);
				response.setMessage("PipeLineList is not inserted");
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
