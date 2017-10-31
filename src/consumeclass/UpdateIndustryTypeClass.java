package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.IndustryTypeModel;
import response.IndustryTypeResponse;
import utils.Constants;

public class UpdateIndustryTypeClass {
public static IndustryTypeResponse updateIndustryType(IndustryTypeModel model){
	IndustryTypeResponse response=new IndustryTypeResponse();
	 Connection connection=null;
		CallableStatement callstatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int Typeid=model.getIndustryTypeId();
			String typename=model.getTypeName();
			boolean isactive=model.getIsActive();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 Date date = new Date();
			 System.out.println(dateFormat.format(date));
			 String ModifiedDate=dateFormat.format(date);
			String query="{CALL `Settings.IndustryType_UpdateIndustryType`(?,?,?,?)}";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callstatement = connection.prepareCall(query);
			callstatement.setInt(1,Typeid );
			callstatement.setString(2, typename);
			callstatement.setBoolean(3, isactive);
			callstatement.setString(4, ModifiedDate);
			int count = callstatement.executeUpdate();
			if(count>0){
				response.setIsSuccess(true);
				response.setMessage("Industrytype updated Successfully");
				response.setIndustryType(null);
			}else{
				response.setIsSuccess(false);
				response.setMessage("Industrytype is not updated or type id not exist");
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
