package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.ReminderEmailModel;

public class ReminderEmailResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
private String message;
	@XmlElement(name="ReminderEmailList")
private ArrayList<ReminderEmailModel>reminderEmailList=new ArrayList<ReminderEmailModel>();
public ReminderEmailResponse(){
	
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
public ArrayList<ReminderEmailModel> getReminderEmailList() {
	return reminderEmailList;
}
public void setReminderEmailList(ArrayList<ReminderEmailModel> reminderEmailList) {
	this.reminderEmailList = reminderEmailList;
}

}
