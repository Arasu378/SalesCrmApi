package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.CurrencyModel;
import response.CurrencyResponse;
import utils.Constants;

public class UpdateCurrencyClass {
	public static CurrencyResponse updateCurrency(CurrencyModel input){
		CurrencyResponse response=new CurrencyResponse();
		int CurrencyId=input.getCurrencyId();
		String CurrencyCode=input.getCurrencyCode();
		String CurrencyName=input.getCurrencyName();
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
				String query="{CALL `Settings.Currency_UpdateCurrency`(?,?,?,?)}";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				callstatement = connection.prepareCall(query);
				callstatement.setInt(1,CurrencyId );
				callstatement.setString(2, CurrencyCode);
				callstatement.setString(3, CurrencyName);
				callstatement.setString(4, ModifiedDate);
			//	callstatement.execute();
				int count = callstatement.executeUpdate();
				if(count>0){
					response.setIsSuccess(true);
					response.setMessage("Currency updated Successfully");
					response.setCurrencyModel(null);
				}else{
					response.setIsSuccess(false);
					response.setMessage("Currency is not updated or Currency id is not existed");
					response.setCurrencyModel(null);
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
