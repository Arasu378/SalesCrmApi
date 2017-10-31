package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.GoogleContactsModel;

public class GoogleContactsResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
private String message;
	@XmlElement(name="GoogleContactList")
private ArrayList<GoogleContactsModel>googleContactList=new ArrayList<GoogleContactsModel>();
	public GoogleContactsResponse(){
		
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
	public ArrayList<GoogleContactsModel> getGoogleContactList() {
		return googleContactList;
	}
	public void setGoogleContactList(
			ArrayList<GoogleContactsModel> googleContactList) {
		this.googleContactList = googleContactList;
	}
	
}
