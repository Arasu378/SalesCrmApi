package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.IndustryTypeModel;
import response.IndustryTypeResponse;
import utils.Constants;

public class InsertIndustryTypeClass {
	public static IndustryTypeResponse insertdata(IndustryTypeModel model){
		IndustryTypeResponse response =new IndustryTypeResponse();
		Connection connection=null;
 		CallableStatement callstatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String TypeName=model.getTypeName();
			String query="{CALL `Settings.IndustryType_InsertIndustryType`(?)}";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callstatement = connection.prepareCall(query);
			callstatement.setString(1,TypeName );
			int count = callstatement.executeUpdate();
			if(count>0){
				response.setIsSuccess(true);
				response.setMessage("IndustryType inserted Successfully");
				response.setIndustryType(null);
			}else{
				response.setIsSuccess(false);
				response.setMessage("IndustryType is not inserted");
				response.setIndustryType(null);
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
			if(callstatement!=null){
				try{
					callstatement.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return response;
	}

}
