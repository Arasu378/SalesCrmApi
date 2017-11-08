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
				usersModel.setUserId(userId);
				String name=rs.getString(UsersDBConstants.NAME);
				if(name==null){
					name="";
				}
				usersModel.setName(name);
				String defaultCurrency=rs.getString(UsersDBConstants.DEFAULT_CURRENCY);
				if(defaultCurrency==null){
					defaultCurrency="";
				}
				usersModel.setDefaultCurrency(defaultCurrency);
				String locale=rs.getString(UsersDBConstants.LOCALE);
				if(locale==null){
					locale="";
				}
				usersModel.setLocale(locale);
				String lang=rs.getString(UsersDBConstants.LANG);
				if(lang==null){
					lang="";
				}
				usersModel.setLang(lang);
				String email=rs.getString(UsersDBConstants.EMAIL);
				if(email==null){
					email="";
				}
				usersModel.setEmail(email);
				String phone=rs.getString(UsersDBConstants.PHONE);
				if(phone==null){
					phone="";
				}
				usersModel.setPhone(phone);
				boolean activated=rs.getBoolean(UsersDBConstants.ACTIVATED);
				usersModel.setActivated(activated);
				String lastLogin=rs.getString(UsersDBConstants.LAST_LOGIN);
				if(lastLogin==null){
					lastLogin="";
				}
				usersModel.setLastLogin(lastLogin);
				String created=rs.getString(UsersDBConstants.CREATED);
				if(created==null){
					created="";
				}
				usersModel.setCreated(created);
				String modified=rs.getString(UsersDBConstants.MODIFIED);
				if(modified==null){
					modified="";
				}
				usersModel.setModified(modified);
				String signupFlowVariation=rs.getString(UsersDBConstants.SIGNUP_FLOW_VARIATION);
				if(signupFlowVariation==null){
					signupFlowVariation="";
				}
				usersModel.setSignupFlowVariation(signupFlowVariation);
				boolean hasCreatedCompany=rs.getBoolean(UsersDBConstants.HAS_CREATED_COMPANY);
				usersModel.setHasCreatedCompany(hasCreatedCompany);
				boolean isAdmin=rs.getBoolean(UsersDBConstants.IS_ADMIN);
				usersModel.setIsAdmin(isAdmin);
				String timeZoneName=rs.getString(UsersDBConstants.TIME_ZONE_NAME);
				if(timeZoneName==null){
					timeZoneName="";
				}
				usersModel.setTimeZoneName(timeZoneName);
				String timeZoneOffset=rs.getString(UsersDBConstants.TIME_ZONE_OFFSET);
				if(timeZoneOffset==null){
					timeZoneOffset="";
				}
				usersModel.setTimeZoneOffset(timeZoneOffset);
				boolean activeFlag=rs.getBoolean(UsersDBConstants.ACTIVE_FLAG);
				usersModel.setActiveFlag(activeFlag);
				int roleId=rs.getInt(UsersDBConstants.ROLE_ID);
				usersModel.setRoleId(roleId);
				String iconUrl=rs.getString(UsersDBConstants.ICON_URL);
				if(iconUrl==null){
					iconUrl="";
				}
				usersModel.setIconUrl(iconUrl);
				boolean isYou=rs.getBoolean(UsersDBConstants.IS_YOU);
				usersModel.setIsYou(isYou);
				int userProfileId=rs.getInt(UsersDBConstants.USER_PROFILE_ID);
				usersModel.setUserProfileId(userProfileId);
				
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
