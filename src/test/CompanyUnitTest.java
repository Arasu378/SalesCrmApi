package test;

import static org.junit.Assert.assertEquals;
import model.CompanyModel;

import org.junit.Test;

import response.CompanyResponse;
import consumeclass.DeleteCompanyClass;
import consumeclass.GetCompanyByCompanyIdClass;
import consumeclass.GetCompanyByUserProfileIdClass;
import consumeclass.InsertCompanyClass;
import consumeclass.UpdateCompanyClass;

public class CompanyUnitTest {
//	@Test
//	public void getCompanyByCompanyId(){
//		CompanyResponse response=GetCompanyByCompanyIdClass.getCompanybyCompanyId(100001);
//		assertEquals("getCompanybyCompanyId",response.getIsSuccess(),false);
//
//		
//	}
//	@Test
//	public void getCompanyByUserProfileId(){
//		CompanyResponse response=GetCompanyByUserProfileIdClass.getCompanyByUserProfileId(1);
//		assertEquals("getCompanybyUserProfileId",response.getIsSuccess(),false);
//	}
//	@Test
//	public void insertCompany(){
//		CompanyModel model=new CompanyModel();
//		model.setUserProfileId(100001);
//		model.setCompanyCode("bb97eb56-8caf-11e7-a7f1-1c1b0dafb5df");
//		model.setCompanyName("abc pvt ltd");
//		CompanyResponse response=InsertCompanyClass.insertCompany(model);
//		assertEquals("insertCompany",response.getIsSuccess(),true);
//	}
//	@Test
//	public void updateCompany(){
//		CompanyModel model=new CompanyModel();
//		model.setUserProfileId(100001);
//		model.setCompanyCode("bb97eb56-8caf-11e7-a7f1-1c1b0dafb5df");
//		model.setCompanyName("abc pvts ltd");
//		model.setCompanyId(100002);
//		CompanyResponse response=UpdateCompanyClass.updateCompany(model);
//		assertEquals("updateCompany",response.getIsSuccess(),true);
//	}
	
	
//	@Test
//	public void deleteCompany(){
//		CompanyModel model=new CompanyModel();
//		model.setCompanyId(100002);
//		CompanyResponse response=DeleteCompanyClass.deleteCompany(model);
//		assertEquals("deleteCompany",response.getIsSuccess(),true);
//	}
}
