package model;

import javax.xml.bind.annotation.XmlElement;

public class EmailIntegrationModel {
	@XmlElement(name="EmailIntegrationId")
private int emailIntegrationId;
	@XmlElement(name="UserProfileId")
private int userProfileId;
	@XmlElement(name="AlternativeEmailAddress")
private String alternativeEmailAddress;
	@XmlElement(name="IsMyLinkedEmailsShared")
private boolean isMyLinkedEmailsShared;
	@XmlElement(name="IsMyEmailConversationsPrivate")
private boolean isMyEmailConversationsPrivate;
	@XmlElement(name="IsLinkMyEmailManually")
private boolean isLinkMyEmailManually;
	@XmlElement(name="IsEmailLinkWithDeals")
private boolean isEmailLinkWithDeals;
	@XmlElement(name="IsActive")
private boolean isActive;
	@XmlElement(name="CreatedDate")
private String createdDate;
	@XmlElement(name="ModifiedDate")
private String modifiedDate;
public EmailIntegrationModel(){
	
}
public int getEmailIntegrationId() {
	return emailIntegrationId;
}
public void setEmailIntegrationId(int emailIntegrationId) {
	this.emailIntegrationId = emailIntegrationId;
}
public int getUserProfileId() {
	return userProfileId;
}
public void setUserProfileId(int userProfileId) {
	this.userProfileId = userProfileId;
}
public String getAlternativeEmailAddress() {
	return alternativeEmailAddress;
}
public void setAlternativeEmailAddress(String alternativeEmailAddress) {
	this.alternativeEmailAddress = alternativeEmailAddress;
}
public boolean getIsMyLinkedEmailsShared() {
	return isMyLinkedEmailsShared;
}
public void setIsMyLinkedEmailsShared(boolean isMyLinkedEmailsShared) {
	this.isMyLinkedEmailsShared = isMyLinkedEmailsShared;
}
public boolean getIsMyEmailConversationsPrivate() {
	return isMyEmailConversationsPrivate;
}
public void setIsMyEmailConversationsPrivate(boolean isMyEmailConversationsPrivate) {
	this.isMyEmailConversationsPrivate = isMyEmailConversationsPrivate;
}
public boolean getIsLinkMyEmailManually() {
	return isLinkMyEmailManually;
}
public void setIsLinkMyEmailManually(boolean isLinkMyEmailManually) {
	this.isLinkMyEmailManually = isLinkMyEmailManually;
}
public boolean getIsEmailLinkWithDeals() {
	return isEmailLinkWithDeals;
}
public void setIsEmailLinkWithDeals(boolean isEmailLinkWithDeals) {
	this.isEmailLinkWithDeals = isEmailLinkWithDeals;
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
