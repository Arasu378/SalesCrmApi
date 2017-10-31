package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class ReminderTimeModel  implements Serializable{
	private static final long serialVersionUID = 1L;
@XmlElement(name="ReminderTimeId")
private int reminderTimeId;
@XmlElement(name="ReminderTimeName")
private String reminderTimeName;
@XmlElement(name="IsActive")
private boolean isActive;
@XmlElement(name="CreatedDate")
private String createdDate;
@XmlElement(name="ModifiedDate")
private String modifiedDate;
public ReminderTimeModel(){
	
}
public int getReminderTimeId() {
	return reminderTimeId;
}
public void setReminderTimeId(int reminderTimeId) {
	this.reminderTimeId = reminderTimeId;
}
public String getReminderTimeName() {
	return reminderTimeName;
}
public void setReminderTimeName(String reminderTimeName) {
	this.reminderTimeName = reminderTimeName;
}
public boolean getIsActive() {
	return isActive;
}
public void setIsActive(boolean isActive) {
	this.isActive = isActive;
}
public String getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(String createdDate) {
	this.createdDate = createdDate;
}
public String getModifiedDate() {
	return modifiedDate;
}
public void setModifiedDate(String modifiedDate) {
	this.modifiedDate = modifiedDate;
}


}
