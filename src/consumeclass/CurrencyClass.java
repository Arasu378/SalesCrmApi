package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.CurrencyModel;
import response.CurrencyResponse;
import utils.Constants;
//test
public class CurrencyClass {
	private static ArrayList<CurrencyModel>currencyList=new ArrayList<CurrencyModel>();
	public static void main(String[] args) {
		

	}
	public static  CurrencyResponse getCurrency(){
		CurrencyResponse curResponse=new CurrencyResponse();
		currencyList.clear();
		 Connection connection=null;
		 java.sql.Statement st=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				String query="CALL `Settings.Currency_GetCurrency`();";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				st=connection.createStatement();
				   ResultSet rs=st.executeQuery(query);
				   
				   while(rs.next()){
					   CurrencyModel cuModel=new CurrencyModel();
					   int CurrencyId=rs.getInt(dbconstants.CurrencyDBConstants.CURRENCY_ID);
					   cuModel.setCurrencyId(CurrencyId);
					   String CurrencyCode=rs.getString(dbconstants.CurrencyDBConstants.CURRENCY_CODE);
					   if(CurrencyCode==null){
						   CurrencyCode="";
					   }
					   cuModel.setCurrencyCode(CurrencyCode);
					   String CurrencyName=rs.getString(dbconstants.CurrencyDBConstants.CURRENCY_NAME);
					   if(CurrencyName==null){
						   CurrencyName="";
					   }
					   cuModel.setCurrencyName(CurrencyName);
					   boolean IsActive=rs.getBoolean(dbconstants.CurrencyDBConstants.ISACTIVE);
					   cuModel.setActive(IsActive);
					   String CreatedDate=rs.getString(dbconstants.CurrencyDBConstants.CREATED_DATE);
					   if(CreatedDate==null){
						   CreatedDate="";
					   }
					   cuModel.setCreatedDate(CreatedDate);
					   String ModifiedDate=rs.getString(dbconstants.CurrencyDBConstants.MODIFIED_DATE);
					   if(ModifiedDate==null){
						   ModifiedDate="";
					   }
					   cuModel.setModifiedDate(ModifiedDate);
					   currencyList.add(cuModel);
				   }
				   if(currencyList!=null&&currencyList.size()!=0){
					   curResponse.setIsSuccess(true);
					   curResponse.setMessage("");
					   curResponse.setCurrencyModel(currencyList);
				   }else{
					   curResponse.setIsSuccess(false);
					   curResponse.setMessage("CurrencyList is Empty or Null!");
					   curResponse.setCurrencyModel(null);
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
		
		return curResponse;
	}

}
