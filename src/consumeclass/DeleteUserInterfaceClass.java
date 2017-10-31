package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.UserInterfaceModel;
import response.UserInterfaceResponse;
import utils.Constants;

public class DeleteUserInterfaceClass {
public static UserInterfaceResponse delteUserInterface(UserInterfaceModel model){
	UserInterfaceResponse response=new UserInterfaceResponse();
	Connection connection=null;
	 java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int userInterfaceId=model.getUserInterfaceId();
			String query="CALL `UserSettings.UserInterface_DeleteUserInterface`("+userInterfaceId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	           PreparedStatement stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           if(i>0){
	        	   response.setUserInterfaceList(null);
	        	   response.setIsSuccess(true);
	        	   response.setMessage("Successfully deleted ");
	           }else{
	        	   response.setUserInterfaceList(null);
	        	   response.setIsSuccess(false);
	        	   response.setMessage("Not deleted or userinterfaceid does not exist ");
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
