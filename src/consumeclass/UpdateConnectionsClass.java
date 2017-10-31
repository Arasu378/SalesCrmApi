package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.ConnectionsModel;
import response.ConnectionsResponse;
import utils.Constants;

public class UpdateConnectionsClass {
public static ConnectionsResponse updateConnections(ConnectionsModel model){
	ConnectionsResponse response=new ConnectionsResponse();
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
		 int connectionId=model.getConnectionId();
		 int profileId=model.getUserProfileId();
		 boolean isConnectedGoogle=model.getIsConnectedToGoogleAccount();
		 boolean isConnectedMailChimp=model.getIsConnectedToMailChimpAccount();
		 String googleAccountEmail=model.getGoogleAccountEmail();
		 String mailChimpAccountEmail=model.getMailChimpAccountEmail();
		 boolean isactive=model.getIsActive();
		 System.out.println(dateFormat.format(date));
		 String ModifiedDate=dateFormat.format(date);
		String query="{CALL  `UserSettings.Connection_UpdateConnections`(?,?,?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callstatement = connection.prepareCall(query);
		callstatement.setInt(1,connectionId );
		callstatement.setInt(2,profileId );
		callstatement.setBoolean(3, isConnectedGoogle);
		callstatement.setBoolean(4, isConnectedMailChimp);
		callstatement.setString(5, googleAccountEmail);
		callstatement.setString(6, mailChimpAccountEmail);
		callstatement.setBoolean(7, isactive);
		callstatement.setString(8, ModifiedDate);
		int count = callstatement.executeUpdate();
		if(count>0){
			response.setIsSuccess(true);
			response.setMessage("Connections updated Successfully");
			response.setConnectionList(null);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Connections is not updated or connection id is not existed");
			response.setConnectionList(null);
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
