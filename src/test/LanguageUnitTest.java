package test;

import static org.junit.Assert.assertEquals;
import model.LanguageModel;

import org.junit.Test;

import consumeclass.DeleteLanguageClass;
import consumeclass.InsertLanguageClass;
import consumeclass.LanguageClass;
import consumeclass.UpadateLanguageClass;
import response.LanguageResponse;

public class LanguageUnitTest {
@Test
public void getLanguage(){
	LanguageResponse res=LanguageClass.getLanguage();
	System.out.println("list : "+res.getLanguageList().get(1).getLanguageName());
	assertEquals("getLanguage",res.getIsSuccess(),true);
}
//@Test
//public void insertLanguage(){
//	LanguageModel model=new LanguageModel();
//	model.setLanguageCultureName("cul");
//	model.setLanguageName("just name");
//	LanguageResponse res=InsertLanguageClass.insertLanguage(model);
//	assertEquals("insertLanguage",res.getIsSuccess(),true);
//
//}
//@Test
//public void updateLanguage(){
//	LanguageModel model=new LanguageModel();
//	model.setLanguageId(138);
//	model.setLanguageCultureName("ck");
//	model.setLanguageName("just namea");
//	LanguageResponse res=UpadateLanguageClass.updateLanguage(model);
//	assertEquals("updateLanguage",res.getIsSuccess(),true);
//}
//@Test
//public void deleteLanguage(){
//	LanguageModel model=new LanguageModel();
//	model.setLanguageId(138);
//	LanguageResponse res=DeleteLanguageClass.deleteLanguage(model);
//	assertEquals("updateLanguage",res.getIsSuccess(),true);
//}
}
