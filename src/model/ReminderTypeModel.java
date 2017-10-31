package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class ReminderTypeModel implements Serializable{
	private static final long serialVersionUID = 1L;
@XmlElement(name="ReminderTypeId")
private int reminderTypeId;
@XmlElement(name="ReminderTypeName")
private String reminderTypeName;
@XmlElement(name="IsActive")
private boolean isActive;
@XmlElement(name="CreatedDate")
private String createdDate;
@XmlElement(name="ModifiedDate")
private String modifiedDate;
public ReminderTypeModel(){
	
}
public int getReminderTypeId() {
	return reminderTypeId;
}
public void setReminderTypeId(int reminderTypeId) {
	this.reminderTypeId = reminderTypeId;
}
public String getReminderTypeName() {
	return reminderTypeName;
}
public void setReminderTypeName(String reminderTypeName) {
	this.reminderTypeName = reminderTypeName;
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
