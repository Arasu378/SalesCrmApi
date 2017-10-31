package test;

import static org.junit.Assert.assertEquals;
import model.IndustryTypeModel;

import org.junit.Test;

import consumeclass.DeleteIndustryTypeClass;
import consumeclass.IndustryTypeClass;
import consumeclass.InsertIndustryTypeClass;
import consumeclass.UpdateIndustryTypeClass;
import response.IndustryTypeResponse;

public class IndustryTypeUnitTest {
	@Test
public void getIndustryType(){
IndustryTypeResponse res=IndustryTypeClass.getIndustryType();
System.out.println("list : "+res.getIndustryType().get(1).getTypeName());
assertEquals("getIndustrytype",res.getIsSuccess(),true);
}
//	@Test
//	public void insertIndustryType(){
//		IndustryTypeModel model=new IndustryTypeModel();
//		model.setTypeName("test");
//		IndustryTypeResponse res=InsertIndustryTypeClass.insertdata(model);
//		assertEquals("insertIndustrytype",res.getIsSuccess(),true);
//	}
	
//	@Test
//	public void updateIndustryType(){
//		IndustryTypeModel model=new IndustryTypeModel();
//		model.setIndustryTypeId(18);
//		model.setTypeName("tested");
//		model.setIsActive(true);
//		IndustryTypeResponse res=UpdateIndustryTypeClass.updateIndustryType(model);
//		assertEquals("updateIndustrytype",res.getIsSuccess(),true);
//	}
//	@Test
//	public void deleteIndustryType(){
//		IndustryTypeModel model=new IndustryTypeModel();
//		model.setIndustryTypeId(18);
//		IndustryTypeResponse res=DeleteIndustryTypeClass.deleteIndustryType(model);
//	assertEquals("updateIndustrytype",res.getIsSuccess(),false);
//	}
}
