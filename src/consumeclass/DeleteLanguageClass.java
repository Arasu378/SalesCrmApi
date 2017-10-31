package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.LanguageModel;
import response.LanguageResponse;
import utils.Constants;

public class DeleteLanguageClass {
public static LanguageResponse deleteLanguage(LanguageModel model){
	LanguageResponse response=new LanguageResponse();
	Connection connection=null;
	 java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int languageid=model.getLanguageId();
			String query="CALL `Settings.Language_DeleteLanguage`("+languageid+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	           PreparedStatement stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           if(i>0){
	        	   response.setLanguageList(null);
	        	   response.setIsSuccess(true);
	        	   response.setMessage("Successfully deleted ");
	           }else{
	        	   response.setLanguageList(null);
	        	   response.setIsSuccess(false);
	        	   response.setMessage("Not deleted or language id does not exist ");
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
