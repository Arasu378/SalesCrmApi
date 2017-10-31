package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.LanguageModel;
import response.LanguageResponse;
import utils.Constants;

public class UpadateLanguageClass {
public static LanguageResponse updateLanguage(LanguageModel model){
	LanguageResponse response=new LanguageResponse();
	 Connection connection=null;
		CallableStatement callstatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int languageId=model.getLanguageId();
			String cultureName=model.getLanguageCultureName();
			String languageName=model.getLanguageName();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 Date date = new Date();
			 System.out.println(dateFormat.format(date));
			 String ModifiedDate=dateFormat.format(date);
			String query="{CALL `Settings.Language_UpdateLanguage`(?,?,?,?)}";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callstatement = connection.prepareCall(query);
			callstatement.setInt(1,languageId );
			callstatement.setString(2, cultureName);
			callstatement.setString(3, languageName);
			callstatement.setString(4, ModifiedDate);
		//	callstatement.execute();
			int count = callstatement.executeUpdate();
			if(count>0){
				response.setIsSuccess(true);
				response.setMessage("Language updated Successfully");
				response.setLanguageList(null);
			}else{
				response.setIsSuccess(false);
				response.setMessage("Language is not updated or Language id is not existed");
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
