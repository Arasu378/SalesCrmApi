package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.CompanyModel;
import response.CompanyResponse;
import utils.Constants;

public class UpdateCompanyClass {
public static CompanyResponse updateCompany(CompanyModel model){
	CompanyResponse response=new CompanyResponse();
	int companyId=model.getCompanyId();
	int profileId=model.getUserProfileId();
	String companyName=model.getCompanyName();
	boolean isActive=model.getIsActive();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 Date date = new Date();
	 System.out.println(dateFormat.format(date));
	 String ModifiedDate=dateFormat.format(date);
	 Connection connection=null;
 		CallableStatement callstatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="{CALL `UserSettings.Company_UpdateCompany`(?,?,?,?,?)}";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callstatement = connection.prepareCall(query);
			callstatement.setInt(1,companyId );
			callstatement.setInt(2, profileId);
			callstatement.setString(3, companyName);
			callstatement.setBoolean(4, isActive);
			callstatement.setString(5, ModifiedDate);
			int count = callstatement.executeUpdate();
			if(count>0){
				response.setIsSuccess(true);
				response.setMessage("Company updated Successfully");
				response.setCompanyList(null);
			}else{
				response.setIsSuccess(false);
				response.setMessage("Company is not updated or Company id not existed");
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
