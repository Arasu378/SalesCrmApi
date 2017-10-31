package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.UserLocaleModel;
import response.UserLocaleResponse;
import utils.Constants;

public class DeleteUserLocaleClass {

	public static UserLocaleResponse deleteUserLocale(UserLocaleModel model){
		UserLocaleResponse response=new UserLocaleResponse();
		Connection connection=null;
		 java.sql.Statement st=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				int userLocaleId=model.getUserLocaleId();
				String query="CALL `Settings.UserLocale_DeleteUserLocale`("+userLocaleId+");";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		           PreparedStatement stmt = connection.prepareStatement(query);
		           int i=stmt.executeUpdate();
		           if(i>0){
		        	   response.setUserLocaleList(null);
		        	   response.setIsSuccess(true);
		        	   response.setMessage("Successfully deleted ");
		           }else{
		        	   response.setUserLocaleList(null);
		        	   response.setIsSuccess(false);
		        	   response.setMessage("Not deleted or userlocale id does not exist ");
		           }
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
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
