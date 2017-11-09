package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import response.CurrencyResponse;
import utils.Constants;
import model.CurrencyModel;

public class InsertCurrencyClass {
	public static CurrencyResponse insertCurrency(CurrencyModel input){
		CurrencyResponse response=new CurrencyResponse();
		Connection connection=null;
 		CallableStatement callstatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String Currencycode=input.getCurrencyCode();
			String CurrencyName=input.getCurrencyName();
			String query="{CALL `Settings.Currency_InsertCurrency`(?,?)}";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callstatement = connection.prepareCall(query);
			callstatement.setString(1,Currencycode );
			callstatement.setString(2, CurrencyName);
			//callstatement.execute();
			int count = callstatement.executeUpdate();
			if(count>0){
				response=CurrencyClass.getCurrency();
			}else{
				response.setIsSuccess(false);
				response.setMessage("Currency is not inserted");
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
