package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dbconstants.UsersDBConstants;
import model.UsersModel;
import response.UsersResponse;
import utils.Constants;

public class GetUsersByUserProfileIdClass {
	private static ArrayList<UsersModel>usersList=new ArrayList<UsersModel>();
	public static UsersResponse getUsersByUserProfileId(int UserProfileId){
		UsersResponse response=new UsersResponse();
		Connection connection=null;
		Statement st=null;
		usersList.clear();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			String query="CALL `Company.Users_GetUsersByUserProfileId`("+UserProfileId+")";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			st=connection.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
				UsersModel usersModel=new UsersModel();
				int userId=rs.getInt(UsersDBConstants.USER_ID);
				String name=rs.getString(UsersDBConstants.NAME);
				String defaultCurrency=rs.getString(UsersDBConstants.DEFAULT_CURRENCY);
				String locale=rs.getString(UsersDBConstants.LOCALE);
				String lang=rs.getString(UsersDBConstants.LANG);
				String email=rs.getString(UsersDBConstants.EMAIL);
				String phone=rs.getString(UsersDBConstants.PHONE);
				boolean activated=rs.getBoolean(UsersDBConstants.ACTIVATED);
				String lastLogin=rs.getString(UsersDBConstants.LAST_LOGIN);
				String created=rs.getString(UsersDBConstants.CREATED);
				String modified=rs.getString(UsersDBConstants.MODIFIED);
				String signupFlowVariation=rs.getString(UsersDBConstants.SIGNUP_FLOW_VARIATION);
				boolean hasCreatedCompany=rs.getBoolean(UsersDBConstants.HAS_CREATED_COMPANY);
				boolean isAdmin=rs.getBoolean(UsersDBConstants.IS_ADMIN);
				String timeZoneName=rs.getString(UsersDBConstants.TIME_ZONE_NAME);
				String timeZoneOffset=rs.getString(UsersDBConstants.TIME_ZONE_OFFSET);
				boolean activeFlag=rs.getBoolean(UsersDBConstants.ACTIVE_FLAG);
				int roleId=rs.getInt(UsersDBConstants.ROLE_ID);
				String iconUrl=rs.getString(UsersDBConstants.ICON_URL);
				boolean isYou=rs.getBoolean(UsersDBConstants.IS_YOU);
				int userProfileId=rs.getInt(UsersDBConstants.USER_PROFILE_ID);
				
				usersList.add(usersModel);
			}
			if(usersList!=null && usersList.size()!=0){
				response.setIsSuccess(true);
				response.setMessage("");
				response.setUsersList(usersList);
			}else{
				response.setIsSuccess(false);
				response.setMessage("UsersList is empty or null");
				response.setUsersList(null);
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
