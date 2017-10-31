package model;

import javax.xml.bind.annotation.XmlElement;

public class ConnectionsModel {
	@XmlElement(name="ConnectionId")
private int connectionId;
	@XmlElement(name="UserProfileId")
private int userProfileId;
	@XmlElement(name="IsConnectedToGoogleAccount")
private boolean isConnectedToGoogleAccount;
	@XmlElement(name="IsConnectedToMailChimpAccount")
private boolean isConnectedToMailChimpAccount;
	@XmlElement(name="GoogleAccountEmail")
private String googleAccountEmail;
	@XmlElement(name="MailChimpAccountEmail")
private String mailChimpAccountEmail;
	@XmlElement(name="IsActive")
private boolean isActive;
	@XmlElement(name="CreatedDate")
private String createdDate;
	@XmlElement(name="ModifiedDate")
private String modifiedDate;
	public ConnectionsModel(){
		
	}
	public int getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	public boolean getIsConnectedToGoogleAccount() {
		return isConnectedToGoogleAccount;
	}
	public void setIsConnectedToGoogleAccount(boolean isConnectedToGoogleAccount) {
		this.isConnectedToGoogleAccount = isConnectedToGoogleAccount;
	}
	public boolean getIsConnectedToMailChimpAccount() {
		return isConnectedToMailChimpAccount;
	}
	public void setIsConnectedToMailChimpAccount(boolean isConnectedToMailChimpAccount) {
		this.isConnectedToMailChimpAccount = isConnectedToMailChimpAccount;
	}
	public String getGoogleAccountEmail() {
		return googleAccountEmail;
	}
	public void setGoogleAccountEmail(String googleAccountEmail) {
		this.googleAccountEmail = googleAccountEmail;
	}
	public String getMailChimpAccountEmail() {
		return mailChimpAccountEmail;
	}
	public void setMailChimpAccountEmail(String mailChimpAccountEmail) {
		this.mailChimpAccountEmail = mailChimpAccountEmail;
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
