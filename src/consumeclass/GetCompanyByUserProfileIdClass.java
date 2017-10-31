package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconstants.CompanyDBConstants;
import model.CompanyModel;
import response.CompanyResponse;
import utils.Constants;

public class GetCompanyByUserProfileIdClass {
	private static ArrayList<CompanyModel>companyList=new ArrayList<CompanyModel>();
public static CompanyResponse getCompanyByUserProfileId(int UserProfileId){
	CompanyResponse response=new CompanyResponse();
	companyList.clear();
	 Connection connection=null;
	 java.sql.Statement st=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="CALL  `UserSettings.Company_GetCompanybyUserProfileId`("+UserProfileId+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   
		   while(rs.next()){
			   CompanyModel coModel=new CompanyModel();
			 int companyId=rs.getInt(CompanyDBConstants.COMPANY_ID);
			 int userProfileId=rs.getInt(CompanyDBConstants.USER_PROFILE_ID);
			 String companyCode=rs.getString(CompanyDBConstants.COMPANY_CODE);
			 if(companyCode==null){
				 companyCode="";
			 }
			 String companyName=rs.getString(CompanyDBConstants.COMPANY_NAME);
			 if(companyName==null){
				 companyName="";
			 }
			 boolean isActive=rs.getBoolean(CompanyDBConstants.IS_ACTIVE);
			 String createdDate=rs.getString(CompanyDBConstants.CREATED_DATE);
			 if(createdDate== null){
				 createdDate="";
			 }
			  String modifiedDate=rs.getString(CompanyDBConstants.MODIFIED_DATE);
			  if(modifiedDate==null){
				  modifiedDate="";
			  }
			  coModel.setCompanyId(companyId);
			  coModel.setUserProfileId(userProfileId);
			  coModel.setCompanyCode(companyCode);
			  coModel.setCompanyName(companyName);
			  coModel.setIsActive(isActive);
			  coModel.setCreatedDate(createdDate);
			  coModel.setModifiedDate(modifiedDate);
			  companyList.add(coModel);
		   }
		   if(companyList!=null&&companyList.size()!=0){
			   response.setIsSuccess(true);
			   response.setMessage("");
			   response.setCompanyList(companyList);
		   }else{
			   response.setIsSuccess(false);
			   response.setMessage("Company List is Empty or Null!");
			   response.setCompanyList(null);
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
