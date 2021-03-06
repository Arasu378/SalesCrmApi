package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.ConnectionsModel;
import response.ConnectionsResponse;
import utils.Constants;

public class InsertConnectionsClass {
public static ConnectionsResponse insertConnection(ConnectionsModel model){
	ConnectionsResponse response=new ConnectionsResponse();
	
	 Connection connection=null;
		CallableStatement callstatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="{CALL `UserSettingsConnections.InsertConnections`(?,?,?,?,?)}";
			System.out.println("Query : "+query);
			int profileId=model.getUserProfileId();
			boolean isConnectedToGoogleAccount=model.getIsConnectedToGoogleAccount();
			boolean isConnectedToMailChimpAccount=model.getIsConnectedToMailChimpAccount();
			String googleAccountEmail=model.getGoogleAccountEmail();
			String chimpAccountEmail=model.getMailChimpAccountEmail();
			
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callstatement = connection.prepareCall(query);
			callstatement.setInt(1,profileId );
			callstatement.setBoolean(2, isConnectedToGoogleAccount);
			callstatement.setBoolean(3, isConnectedToMailChimpAccount);
			callstatement.setString(4, googleAccountEmail);
			callstatement.setString(5, chimpAccountEmail);
			int count = callstatement.executeUpdate();
			if(count>0){
				response.setIsSuccess(true);
				response.setMessage("Connections inserted Successfully");
				response.setConnectionList(null);
			}else{
				response.setIsSuccess(false);
				response.setMessage("Connections is not inserted");
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
