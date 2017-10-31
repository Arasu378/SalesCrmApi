package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.PipeLineModel;
import response.PipeLineResponse;
import utils.Constants;

public class DeletePipeLineClass {
	public static PipeLineResponse deletePipeLine(PipeLineModel model){
		PipeLineResponse response=new PipeLineResponse();
		Connection connection=null;
		CallableStatement callableStatement=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			String query="{CALL `Settings.PipeLine_DeletePipeLine`(?)}";
			int pipelineid=model.getPipeLineId();
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callableStatement = connection.prepareCall(query);
			callableStatement.setInt(1,pipelineid );
			int count = callableStatement.executeUpdate();
			if(count>0){
				response=(GetAllPipeLineClass.getPipeLine());
			}else{
				response.setIsSuccess(false);
				response.setMessage("PipeLineList is not deleted");
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
