package model;

import javax.xml.bind.annotation.XmlElement;

public class ProfilePictureModel {
	@XmlElement(name="ProfilePictureId")
	private int profilePictureId;
	@XmlElement(name="UserProfileId")
	private int userProfileId;
	@XmlElement(name="AttachmentId")
	private int AttachmentId;
	public ProfilePictureModel(){
		
	}
	public int getProfilePictureId() {
		return profilePictureId;
	}
	public void setProfilePictureId(int profilePictureId) {
		this.profilePictureId = profilePictureId;
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	public int getAttachmentId() {
		return AttachmentId;
	}
	public void setAttachmentId(int attachmentId) {
		AttachmentId = attachmentId;
	}
	

}
