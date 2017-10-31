package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.UserLocaleModel;
import response.UserLocaleResponse;
import utils.Constants;

public class InsertUserLocaleClass {
public static UserLocaleResponse insertUserLocale(UserLocaleModel model){
	UserLocaleResponse response=new UserLocaleResponse();
	
	Connection connection=null;
	CallableStatement callstatement=null;
try {
	Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e1) {
	e1.printStackTrace();
}
try{
	String query="{CALL  `Settings.UserLocale_InsertUserLocale`(?,?)}";
	System.out.println("Query : "+query);
	String localecode=model.getLocaleCode();
	String userLocale=model.getUserLocale();
	connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	callstatement = connection.prepareCall(query);
	callstatement.setString(1,localecode );
	callstatement.setString(2,userLocale );

	int count = callstatement.executeUpdate();
	if(count>0){
		response.setIsSuccess(true);
		response.setMessage("UserLocale inserted Successfully");
		response.setUserLocaleList(null);
	}else{
		response.setIsSuccess(false);
		response.setMessage("UserLocale is not inserted");
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
