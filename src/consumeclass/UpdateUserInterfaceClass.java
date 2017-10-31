package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.UserInterfaceModel;
import response.UserInterfaceResponse;
import utils.Constants;

public class UpdateUserInterfaceClass {
public static UserInterfaceResponse updateUserInterface(UserInterfaceModel model){
	UserInterfaceResponse response=new UserInterfaceResponse();
	Connection connection=null;
	CallableStatement callstatement=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		int userInterfaceId=model.getUserInterfaceId();
		boolean isDeal=model.getIsDeal();
		boolean isPerson=model.getIsPerson();
		boolean isOrganization=model.getIsOrganization();
		boolean isActive=model.getIsActive();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 System.out.println(dateFormat.format(date));
		 String ModifiedDate=dateFormat.format(date);
		String query="{CALL  `UserSettings.UserInterface_UpdateUserInterface`(?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setInt(1,userInterfaceId );
		callstatement.setBoolean(2, isDeal);
		callstatement.setBoolean(3, isPerson);
		callstatement.setBoolean(4, isOrganization);
		callstatement.setBoolean(5, isActive);
		callstatement.setString(6, ModifiedDate);
		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("UserInterface updated Successfully");
			response.setUserInterfaceList(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("UserInterface is not updated or userinterfaceid is not exist");
			response.setUserInterfaceList(null);
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
