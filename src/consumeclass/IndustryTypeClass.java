package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.IndustryTypeModel;
import response.IndustryTypeResponse;
import utils.Constants;

public class IndustryTypeClass {
	private static ArrayList<IndustryTypeModel>indusArrayList=new ArrayList<IndustryTypeModel>();
public static IndustryTypeResponse getIndustryType(){
			IndustryTypeResponse response=new IndustryTypeResponse();
			indusArrayList.clear();
			 Connection connection=null;
			 java.sql.Statement st=null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
				try{
					String query="CALL `Settings.IndustryType_GetIndustryType`();";
					System.out.println("Query : "+query);
					connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
					st=connection.createStatement();
					   ResultSet rs=st.executeQuery(query);
					   
					   while(rs.next()){
						   IndustryTypeModel inModel=new IndustryTypeModel();
						   int IndustryTypeId=rs.getInt(dbconstants.IndustryTypeDBConstants.INDUSTRY_TYPE_ID);
						   inModel.setIndustryTypeId(IndustryTypeId);
						   String TypeName=rs.getString(dbconstants.IndustryTypeDBConstants.TYPE_NAME);
						   if(TypeName==null){
							   TypeName="";
						   }
						   inModel.setTypeName(TypeName);
						   boolean IsActive=rs.getBoolean(dbconstants.IndustryTypeDBConstants.IS_ACTIVE);
						   inModel.setIsActive(IsActive);
						   String CreatedDate=rs.getString(dbconstants.IndustryTypeDBConstants.CREATED_DATE);
						   	if(CreatedDate==null){
						   		CreatedDate="";
						   	}
						   	inModel.setCreatedDate(CreatedDate);
						   String ModifiedDate=rs.getString(dbconstants.IndustryTypeDBConstants.MODIFIED_DATE);
						   if(ModifiedDate==null){
							   ModifiedDate="";
						   }
						   inModel.setModifiedDate(ModifiedDate);
						   indusArrayList.add(inModel);
					   }
					   if(indusArrayList!=null && indusArrayList.size()!=0){
						   response.setIsSuccess(true);
						   response.setMessage("");
						   response.setIndustryType(indusArrayList);
					   }else{
						   response.setIsSuccess(false);
						   response.setMessage("IndustryType List is empty or null");
						   response.setIndustryType(null);
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
