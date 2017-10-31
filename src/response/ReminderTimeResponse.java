package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.ReminderTimeModel;

public class ReminderTimeResponse {
@XmlElement(name="IsSuccess")
private boolean isSuccess;
@XmlElement(name="Message")
private String message;
@XmlElement(name="ReminderTime")
private ArrayList<ReminderTimeModel>reminderTime=new ArrayList<ReminderTimeModel>();
public ReminderTimeResponse(){
	
}
public boolean getIsSuccess() {
	return isSuccess;
}
public void setIsSuccess(boolean isSuccess) {
	this.isSuccess = isSuccess;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public ArrayList<ReminderTimeModel> getReminderTime() {
	return reminderTime;
}
public void setReminderTime(ArrayList<ReminderTimeModel> reminderTime) {
	this.reminderTime = reminderTime;
}

}
