package model;

import javax.xml.bind.annotation.XmlElement;

public class UserInterfaceModel {
	@XmlElement(name="UserInterfaceId")
private int userInterfaceId;
	@XmlElement(name="UserProfileId")
private int userProfileId;
	@XmlElement(name="IsDeal")
private boolean isDeal;
	@XmlElement(name="IsPerson")
private boolean isPerson;
	@XmlElement(name="IsOrganization")
private boolean isOrganization;
	@XmlElement(name="IsActive")
private boolean isActive;
	@XmlElement(name="CreatedDate")
private String createdDate;
	@XmlElement(name="ModifiedDate")
private String modifiedDate;
public UserInterfaceModel(){
	
}
public int getUserInterfaceId() {
	return userInterfaceId;
}
public void setUserInterfaceId(int userInterfaceId) {
	this.userInterfaceId = userInterfaceId;
}
public int getUserProfileId() {
	return userProfileId;
}
public void setUserProfileId(int userProfileId) {
	this.userProfileId = userProfileId;
}
public boolean getIsDeal() {
	return isDeal;
}
public void setIsDeal(boolean isDeal) {
	this.isDeal = isDeal;
}
public boolean getIsPerson() {
	return isPerson;
}
public void setIsPerson(boolean isPerson) {
	this.isPerson = isPerson;
}
public boolean getIsOrganization() {
	return isOrganization;
}
public void setIsOrganization(boolean isOrganization) {
	this.isOrganization = isOrganization;
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
