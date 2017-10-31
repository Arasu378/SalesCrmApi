package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.GoogleDriveModel;

public class GoogleDriveResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
private String message;
	@XmlElement(name="GoogleDriveList")
private ArrayList<GoogleDriveModel>googleDriveList=new ArrayList<GoogleDriveModel>();
	public GoogleDriveResponse(){
		
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
	public ArrayList<GoogleDriveModel> getGoogleDriveList() {
		return googleDriveList;
	}
	public void setGoogleDriveList(ArrayList<GoogleDriveModel> googleDriveList) {
		this.googleDriveList = googleDriveList;
	}
	

}
