package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.CompanyModel;
import response.CompanyResponse;
import utils.Constants;

public class InsertCompanyClass {
public static CompanyResponse insertCompany(CompanyModel model){
	CompanyResponse response=new CompanyResponse();
	 Connection connection=null;
		CallableStatement callstatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="{CALL `UserSettings.Company_InsertCompany`(?,?,?)}";
			System.out.println("Query : "+query);
			int profileId=model.getUserProfileId();
			String companyCode=model.getCompanyCode();
			String companyName=model.getCompanyName();
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callstatement = connection.prepareCall(query);
			callstatement.setInt(1,profileId );
			callstatement.setString(2, companyCode);
			callstatement.setString(3, companyName);
			int count = callstatement.executeUpdate();
			if(count>0){
				response.setIsSuccess(true);
				response.setMessage("Company inserted Successfully");
				response.setCompanyList(null);
			}else{
				response.setIsSuccess(false);
				response.setMessage("Company is not inserted");
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
