package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.GoogleCalanderModel;

public class GoogleCalanderResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
private String message;
	@XmlElement(name="GoogleCalanderList")
private ArrayList<GoogleCalanderModel>googleCalanderList=new ArrayList<GoogleCalanderModel>();
public GoogleCalanderResponse(){
	
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
public ArrayList<GoogleCalanderModel> getGoogleCalanderList() {
	return googleCalanderList;
}
public void setGoogleCalanderList(
		ArrayList<GoogleCalanderModel> googleCalanderList) {
	this.googleCalanderList = googleCalanderList;
}

}
