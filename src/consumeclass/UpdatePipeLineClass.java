package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.PipeLineModel;
import response.PipeLineResponse;
import utils.Constants;

public class UpdatePipeLineClass {
	public static PipeLineResponse updatePipeLine(PipeLineModel model){
		PipeLineResponse response=new PipeLineResponse();
		Connection connection=null;
		CallableStatement callableStatement=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			String query="{CALL `Settings.PipeLine_UpdatePipeLine`(?,?,?,?,?,?,?)}";
			String name=model.getName();
			String dateModified=model.getDateModified();
			int orderNr=model.getOrderNr();
			boolean isActive=model.getIsActive();
			boolean isSelected=model.getIsSelected();
			boolean isDealProbobality=model.getIsDealProbability();
			int pipeLineId=model.getPipeLineId();
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callableStatement = connection.prepareCall(query);
			callableStatement.setString(1,name );
			callableStatement.setString(2,dateModified );
			callableStatement.setInt(3, orderNr);
			callableStatement.setBoolean(4, isActive);
			callableStatement.setBoolean(5, isSelected);
			callableStatement.setBoolean(6, isDealProbobality);
			callableStatement.setInt(7, pipeLineId);
			int count = callableStatement.executeUpdate();
			if(count>0){
				response=(GetAllPipeLineClass.getPipeLine());
			}else{
				response.setIsSuccess(false);
				response.setMessage("PipeLineList is not Updated");
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
