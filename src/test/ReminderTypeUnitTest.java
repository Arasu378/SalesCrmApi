package test;

import static org.junit.Assert.assertEquals;
import model.ReminderTypeModel;

import org.junit.Test;

import response.ReminderTimeResponse;
import response.ReminderTypeResponse;
import consumeclass.DeleteReminderTypeClass;
import consumeclass.InsertReminderTypeClass;
import consumeclass.ReminderTimeClass;
import consumeclass.ReminderTypeClass;
import consumeclass.UpdateReminderTypeClass;

public class ReminderTypeUnitTest {
	@Test
	public void getReminderType(){
		ReminderTypeResponse response=ReminderTypeClass.getReminderType();
		assertEquals("getReminderType",response.getIsSuccess(),true);

		
	}
//	@Test
//	public void insertReminderType(){
//		ReminderTypeModel model=new ReminderTypeModel();
//		model.setReminderTypeName("test");
//		ReminderTypeResponse response=InsertReminderTypeClass.insertReminderType(model);
//		assertEquals("insertReminderType",response.getIsSuccess(),true);
//	}
//	@Test
//	public void updateReminderType(){
//		ReminderTypeModel model=new ReminderTypeModel();
//		model.setReminderTypeName("tests");
//		model.setReminderTypeId(5);
//		model.setIsActive(true);
//		ReminderTypeResponse response=UpdateReminderTypeClass.updateReminderType(model);
//		assertEquals("updateReminderType",response.getIsSuccess(),true);
//	}
//	@Test
//	public void deleteReminderType(){
//		ReminderTypeModel model=new ReminderTypeModel();
//		model.setReminderTypeId(5);
//		ReminderTypeResponse response=DeleteReminderTypeClass.deleteReminderType(model);
//		assertEquals("deleteReminderType",response.getIsSuccess(),true);
//	}
}
