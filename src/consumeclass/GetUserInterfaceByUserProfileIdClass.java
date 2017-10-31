package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconstants.UserInterfaceDBConstants;
import model.UserInterfaceModel;
import response.UserInterfaceResponse;
import utils.Constants;

public class GetUserInterfaceByUserProfileIdClass {
	private static ArrayList<UserInterfaceModel>userInterfaceList=new ArrayList<UserInterfaceModel>();
public static UserInterfaceResponse getUserInterface(int UserProfileId){
	UserInterfaceResponse response=new UserInterfaceResponse();
	userInterfaceList.clear();
	 Connection connection=null;
	 java.sql.Statement st=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		
		String query="CALL `UserSettings.UserInterface.GetUserInterfaceByUserProfileId`("+UserProfileId+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   
		   while(rs.next()){
			   UserInterfaceModel uiModel=new UserInterfaceModel();
			  int userInterfaceId=rs.getInt(UserInterfaceDBConstants.USER_INTERFACE_ID);
			  int userProfileId=rs.getInt(UserInterfaceDBConstants.USER_PROFILE_ID);
			  boolean isDeal=rs.getBoolean(UserInterfaceDBConstants.IS_DEAL);
			  boolean isPerson=rs.getBoolean(UserInterfaceDBConstants.IS_PERSON);
			  boolean isOrganization=rs.getBoolean(UserInterfaceDBConstants.IS_ORGANIZATION);
			  boolean isActive=rs.getBoolean(UserInterfaceDBConstants.IS_ACTIVE);
			  String createdDate=rs.getString(UserInterfaceDBConstants.CREATED_DATE);
			  if(createdDate==null){
				  createdDate="";
			  }
			  String modifiedDate=rs.getString(UserInterfaceDBConstants.MODIFIED_DATE);
			  if(modifiedDate==null){
				  modifiedDate="";
			  }
			  uiModel.setUserInterfaceId(userInterfaceId);
			  uiModel.setUserProfileId(userProfileId);
			  uiModel.setIsDeal(isDeal);
			  uiModel.setIsPerson(isPerson);
			  uiModel.setIsOrganization(isOrganization);
			  uiModel.setIsActive(isActive);
			  uiModel.setCreatedDate(createdDate);
			  uiModel.setModifiedDate(modifiedDate);	  
			  userInterfaceList.add(uiModel);
		   }
		   if(userInterfaceList!=null&&userInterfaceList.size()!=0){
			   response.setIsSuccess(true);
			   response.setMessage("");
			   response.setUserInterfaceList(userInterfaceList);
		   }else{
			   response.setIsSuccess(false);
			   response.setMessage("userinterface List is Empty or Null!");
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
		if(st!=null){
			try{
				st.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	return response;
	
}
}
