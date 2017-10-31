package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import response.UserLocaleResponse;
import utils.Constants;
import model.UserLocaleModel;

public class UserLocaleClass {
	private static ArrayList<UserLocaleModel>userLocaleList=new ArrayList<UserLocaleModel>();
	public static UserLocaleResponse getUserLocale(){
		UserLocaleResponse response =new UserLocaleResponse();
		userLocaleList.clear();
		Connection connection=null;
		 java.sql.Statement st=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
			
				String query="CALL `Settings.UserLocale_GetUserLocale`();";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				st=connection.createStatement();
				   ResultSet rs=st.executeQuery(query);
				   
				   while(rs.next()){
					   UserLocaleModel modal=new UserLocaleModel();
					   int UserLocaleId=rs.getInt(dbconstants.UserLocaleDBConstants.USER_LOCALE_ID);
					   modal.setUserLocaleId(UserLocaleId);
					   String LocaleCode=rs.getString(dbconstants.UserLocaleDBConstants.LOCALE_CODE);
					   if(LocaleCode==null){
						   LocaleCode="";
					   }
					   modal.setLocaleCode(LocaleCode);
					   String UserLocale=rs.getString(dbconstants.UserLocaleDBConstants.USER_LOCALE);
					   if(UserLocale==null){
						   UserLocale="";
					   }
					   modal.setUserLocale(UserLocale);
					   boolean IsActive=rs.getBoolean(dbconstants.UserLocaleDBConstants.IS_ACTIVE);
					   modal.setIsActive(IsActive);
					   String CreatedDate=rs.getString(dbconstants.UserLocaleDBConstants.CREATED_DATE);
					   if(CreatedDate==null){
						   CreatedDate="";
					   }
					   modal.setCreatedDate(CreatedDate);
					   String ModifiedDate=rs.getString(dbconstants.UserLocaleDBConstants.MODIFIED_DATE);
					   if(ModifiedDate==null){
						   ModifiedDate="";
					   }
					   modal.setModifiedDate(ModifiedDate);
					   userLocaleList.add(modal);
					   
				   }
				   if(userLocaleList!=null && userLocaleList.size()!=0){
					   response.setIsSuccess(true);
					   response.setMessage("");
					   response.setUserLocaleList(userLocaleList);
				   }else{
					   response.setIsSuccess(true);
					   response.setMessage("");
					   response.setUserLocaleList(userLocaleList);   
				   }
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(connection!=null){
					try {
						connection.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				if(st!=null){
					try {
						st.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		return response;
	}

}
