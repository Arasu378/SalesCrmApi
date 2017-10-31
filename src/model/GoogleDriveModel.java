package model;

import javax.xml.bind.annotation.XmlElement;

public class GoogleDriveModel {
	@XmlElement(name="DriveId")
private int driveId;
	@XmlElement(name="UserProfileId")
private int userProfileId;
	@XmlElement(name="IsConnectedToGoogleAccount")
private boolean isConnectedToGoogleAccount;
	@XmlElement(name="GoogleAccountEmail")
private String googleAccountEmail;
	@XmlElement(name="IsActive")
private boolean isActive;
	@XmlElement(name="CreatedDate")
private String createdDate;
	public GoogleDriveModel(){
		
	}
	public int getDriveId() {
		return driveId;
	}
	public void setDriveId(int driveId) {
		this.driveId = driveId;
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
	public String getGoogleAccountEmail() {
		return googleAccountEmail;
	}
	public void setGoogleAccountEmail(String googleAccountEmail) {
		this.googleAccountEmail = googleAccountEmail;
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
	
}
