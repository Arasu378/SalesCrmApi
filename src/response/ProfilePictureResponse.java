package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.ProfilePictureModel;

public class ProfilePictureResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
	private String message;
	@XmlElement(name="ProfilePicture")
	private ArrayList<ProfilePictureModel>profilePicture=new ArrayList<ProfilePictureModel>();
	public ProfilePictureResponse(){
		
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
	public ArrayList<ProfilePictureModel> getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(ArrayList<ProfilePictureModel> profilePicture) {
		this.profilePicture = profilePicture;
	}
	
}
