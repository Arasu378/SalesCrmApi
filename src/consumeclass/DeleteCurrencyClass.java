package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import response.CurrencyResponse;
import utils.Constants;

public class DeleteCurrencyClass {
public static CurrencyResponse deleteCurrency(int CurrencyId){
	CurrencyResponse response =new CurrencyResponse();
	Connection connection=null;
	 java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="CALL `Settings.Currency_DeleteCurrency`("+CurrencyId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	           PreparedStatement stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           if(i>0){
//	        	   response.setCurrencyModel(null);
//	        	   response.setIsSuccess(true);
//	        	   response.setMessage("Successfully deleted ");
	        	   response=CurrencyClass.getCurrency();
	           }else{
	        	   response.setCurrencyModel(null);
	        	   response.setIsSuccess(false);
	        	   response.setMessage("Not deleted  or currency id does not exist");
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
