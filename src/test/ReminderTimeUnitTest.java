package test;

import static org.junit.Assert.assertEquals;
import model.ReminderTimeModel;

import org.junit.Test;

import response.ReminderTimeResponse;
import consumeclass.DeleteReminderTimeClass;
import consumeclass.InsertReminderTimeClass;
import consumeclass.ReminderTimeClass;
import consumeclass.UpdateReminderTimeClass;

public class ReminderTimeUnitTest {
@Test
public void getReminderTime(){
	ReminderTimeResponse response=ReminderTimeClass.getReminderTime();
	assertEquals("getReminderTime",response.getIsSuccess(),true);

	
}
//@Test
//public void insertReminderTime(){
//	ReminderTimeModel model=new ReminderTimeModel();
//	model.setReminderTimeName("test name");
//	ReminderTimeResponse response=InsertReminderTimeClass.insertReminderTime(model);
//	assertEquals("insertReminderTime",response.getIsSuccess(),true);
//
//}
//@Test
//public void updateReminderTime(){
//	ReminderTimeModel model=new ReminderTimeModel();
//	model.setReminderTimeId(6);
//	model.setIsActive(true);
//	model.setReminderTimeName("test name ed");
//	ReminderTimeResponse response=UpdateReminderTimeClass.updateReminderTime(model);
//	assertEquals("updateReminderTime",response.getIsSuccess(),true);
//}

//@Test
//public void deleteReminderTime(){
//	ReminderTimeModel model=new ReminderTimeModel();
//	model.setReminderTimeId(6);
//	ReminderTimeResponse response=DeleteReminderTimeClass.deleteReminderTime(model);
//	assertEquals("updateReminderTime",response.getIsSuccess(),true);
//}
}
