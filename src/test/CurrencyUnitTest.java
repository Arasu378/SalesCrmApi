package test;

import static org.junit.Assert.assertEquals;
import model.CurrencyModel;

import org.junit.Test;

import response.CurrencyResponse;
import consumeclass.CurrencyClass;
import consumeclass.DeleteCurrencyClass;
import consumeclass.InsertCurrencyClass;
import consumeclass.UpdateCurrencyClass;

public class CurrencyUnitTest {
@Test
public void getCurrencyTest(){
CurrencyResponse res=CurrencyClass.getCurrency();
System.out.println("list : "+res.getCurrencyModel().get(1).getCurrencyName());
assertEquals("getCurrency",res.getIsSuccess(),true);
}
//@Test
//public void insertCurrency(){
//	CurrencyModel input=new CurrencyModel();
//	input.setCurrencyCode("tes");
//	input.setCurrencyName("Testing curr");
//	
//	CurrencyResponse resp=InsertCurrencyClass.insertCurrency(input);
//	assertEquals("insertcurrency", resp.getIsSuccess(),true);
//}
//@Test
//public void updateCurrency(){
//	CurrencyModel input=new CurrencyModel();
//	input.setCurrencyCode("ter");
//	input.setCurrencyName("Testing currency");
//	input.setCurrencyId(163);
//	CurrencyResponse resp=UpdateCurrencyClass.updateCurrency(input);
//	System.out.println("message "+resp.getMessage());
//	assertEquals("updateCurrency", resp.getIsSuccess(),false);
//}
//@Test
//public void deleteCurrency(){
//	CurrencyResponse resp=DeleteCurrencyClass.deleteCurrency(163);
//	assertEquals("deletecurrency", resp.getIsSuccess(),true);
//}
}
