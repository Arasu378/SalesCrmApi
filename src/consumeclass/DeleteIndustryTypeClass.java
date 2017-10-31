package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.IndustryTypeModel;
import response.IndustryTypeResponse;
import utils.Constants;

public class DeleteIndustryTypeClass {
	public static IndustryTypeResponse deleteIndustryType(IndustryTypeModel model){
		IndustryTypeResponse response=new IndustryTypeResponse();
		
		Connection connection=null;
		 java.sql.Statement st=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				int typeid=model.getIndustryTypeId();
				String query="CALL `Settings.IndustryType_DeleteIndustryType`("+typeid+");";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		           PreparedStatement stmt = connection.prepareStatement(query);
		           int i=stmt.executeUpdate();
		           if(i>0){
		        	   response.setIndustryType(null);
		        	   response.setIsSuccess(true);
		        	   response.setMessage("Successfully deleted ");
		           }else{
		        	   response.setIndustryType(null);
		        	   response.setIsSuccess(false);
		        	   response.setMessage("Not deleted  or type id does not exist");
		           }
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				if(connection!=null){
					try {
						connection.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				if(st!=null){
					try {
						st.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		return response;
	}

}
