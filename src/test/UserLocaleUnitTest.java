package test;

import static org.junit.Assert.assertEquals;
import model.UserLocaleModel;

import org.junit.Test;

import consumeclass.DeleteUserLocaleClass;
import consumeclass.InsertUserLocaleClass;
import consumeclass.UpdateUserLocaleClass;
import consumeclass.UserLocaleClass;
import response.UserLocaleResponse;

public class UserLocaleUnitTest {
@Test
public void getUserLocale(){
	UserLocaleResponse  response=UserLocaleClass.getUserLocale();
	assertEquals("getUserLocale",response.getIsSuccess(),true);
}
//@Test
//public void insertUserLocale(){
//	UserLocaleModel model=new UserLocaleModel();
//	model.setUserLocale("usr");
//	model.setLocaleCode("code");
//	UserLocaleResponse response=InsertUserLocaleClass.insertUserLocale(model);
//	assertEquals("insertUserLocale",response.getIsSuccess(),true);
//}
//@Test
//public void updateUserLocale(){
//	UserLocaleModel model=new UserLocaleModel();
//	model.setUserLocale("usre");
//	model.setLocaleCode("coded");
//	model.setIsActive(true);
//	model.setUserLocaleId(153);
//	UserLocaleResponse response=UpdateUserLocaleClass.updateUserLocale(model);
//	assertEquals("updateUserLocale",response.getIsSuccess(),true);
//}
//@Test
//public void deleteUserLocale(){
//	UserLocaleModel model=new UserLocaleModel();
//	model.setUserLocaleId(153);
//	UserLocaleResponse response=DeleteUserLocaleClass.deleteUserLocale(model);
//	assertEquals("deleteUserLocale",response.getIsSuccess(),true);
//}
}
