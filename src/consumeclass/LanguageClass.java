package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.LanguageModel;
import response.LanguageResponse;
import utils.Constants;

public class LanguageClass {
	private static ArrayList<LanguageModel>languageList=new ArrayList<LanguageModel>();
	public static LanguageResponse getLanguage(){
		LanguageResponse response=new LanguageResponse();
		languageList.clear();
		Connection connection=null;
		 java.sql.Statement st=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
			try{
				String query="CALL `Settings.Language_GetLanguage`();";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				st=connection.createStatement();
				   ResultSet rs=st.executeQuery(query);
				   
				   while(rs.next()){
					   LanguageModel model=new LanguageModel();
					   int LanguageId=rs.getInt(dbconstants.LanguageDBConstants.LANGUAGE_ID);
					   model.setLanguageId(LanguageId);
					   String LanguageCultureName=rs.getString(dbconstants.LanguageDBConstants.LANGUAGE_CULTURE_NAME);
					  if(LanguageCultureName==null){
						  LanguageCultureName="";
					  }
					  model.setLanguageCultureName(LanguageCultureName);
					   String LanguageName=rs.getString(dbconstants.LanguageDBConstants.LANGUAGE_NAME);
					   if(LanguageName==null){
						   LanguageName="";
					   }
					   model.setLanguageName(LanguageName);
					   boolean IsActive=rs.getBoolean(dbconstants.LanguageDBConstants.IS_ACTIVE);
					   model.setIsActive(IsActive);
					   String CreatedDate=rs.getString(dbconstants.LanguageDBConstants.CREATED_DATE);
					   if(CreatedDate==null){
						   CreatedDate="";
					   }
					   model.setCreatedDate(CreatedDate);
					   String ModifiedDate=rs.getString(dbconstants.LanguageDBConstants.MODIFIED_DATE);
					   if(ModifiedDate==null){
						   ModifiedDate="";
					   }
					   model.setModifiedDate(ModifiedDate);
					   languageList.add(model);
				   }
				if(languageList!=null && languageList.size()!=0){
					response.setIsSuccess(true);
					response.setMessage("");
					response.setLanguageList(languageList);
				}else{
					response.setIsSuccess(false);
					response.setMessage("Language List is empty or null");
					response.setLanguageList(null);
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
