package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.UserLocaleModel;
import response.UserLocaleResponse;
import utils.Constants;

public class UpdateUserLocaleClass {
public static UserLocaleResponse updateUserLocale(UserLocaleModel model){
	UserLocaleResponse response=new UserLocaleResponse();
	Connection connection=null;
	CallableStatement callstatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		int userLocaleId=model.getUserLocaleId();
		String localeCode=model.getLocaleCode();
		String UserLocale=model.getUserLocale();
		
		 boolean isactive=model.getIsActive();
		 
		 System.out.println(dateFormat.format(date));
		 String ModifiedDate=dateFormat.format(date);
		String query="{CALL `Settings.UserLocale_UpdateUserLocale`(?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setInt(1,userLocaleId );
		callstatement.setString(2, localeCode);
		callstatement.setString(3, UserLocale);
		callstatement.setBoolean(4, isactive);
		callstatement.setString(5, ModifiedDate);

		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("UserLocale updated Successfully");
			response.setUserLocaleList(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("UserLocale is not updated or userlocaleid is not exist");
			response.setUserLocaleList(null);
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
