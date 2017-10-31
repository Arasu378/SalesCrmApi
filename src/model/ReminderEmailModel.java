package model;

import javax.xml.bind.annotation.XmlElement;

public class ReminderEmailModel {
	@XmlElement(name="ReminderEmailId")
private int reminderEmailId;
	@XmlElement(name="UserProfileId")
private int userProfileId;
	@XmlElement(name="ReminderTypeId")
private String reminderTypeId;
	@XmlElement(name="ReminderTimeId")
private String reminderTimeId;
	@XmlElement(name="IsActive")
private boolean isActive;
	@XmlElement(name="CreatedDate")
private String createdDate;
	@XmlElement(name="ModifiedDate")
private String modifiedDate;
public ReminderEmailModel(){
	
}
public int getReminderEmailId() {
	return reminderEmailId;
}
public void setReminderEmailId(int reminderEmailId) {
	this.reminderEmailId = reminderEmailId;
}
public int getUserProfileId() {
	return userProfileId;
}
public void setUserProfileId(int userProfileId) {
	this.userProfileId = userProfileId;
}
public String getReminderTypeId() {
	return reminderTypeId;
}
public void setReminderTypeId(String reminderTypeId) {
	this.reminderTypeId = reminderTypeId;
}
public String getReminderTimeId() {
	return reminderTimeId;
}
public void setReminderTimeId(String reminderTimeId) {
	this.reminderTimeId = reminderTimeId;
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
