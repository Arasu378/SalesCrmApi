package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.LanguageModel;
import response.LanguageResponse;
import utils.Constants;

public class InsertLanguageClass {
	public static LanguageResponse insertLanguage(LanguageModel model){
		LanguageResponse response=new LanguageResponse();
		Connection connection=null;
 		CallableStatement callstatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="{CALL `Settings.Language_InsertLanguage`(?,?)}";
			System.out.println("Query : "+query);
			String cultureName=model.getLanguageCultureName();
			String languageName=model.getLanguageName();
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callstatement = connection.prepareCall(query);
			callstatement.setString(1,cultureName );
			callstatement.setString(2, languageName);
			//callstatement.execute();
			int count = callstatement.executeUpdate();
			if(count>0){
				response.setIsSuccess(true);
				response.setMessage("Language inserted Successfully");
				response.setLanguageList(null);
			}else{
				response.setIsSuccess(false);
				response.setMessage("Language is not inserted");
				response.setLanguageList(null);
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
