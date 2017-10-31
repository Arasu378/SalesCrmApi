package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.UserLocaleModel;

public class UserLocaleResponse {
	@XmlElement(name="IsSuccess")
	private boolean isSuccess;
	@XmlElement(name="Message")
	private String message;
	@XmlElement(name="UserLocaleList")
	private ArrayList<UserLocaleModel>userLocaleList=new ArrayList<UserLocaleModel>();
public UserLocaleResponse(){
	
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
public ArrayList<UserLocaleModel> getUserLocaleList() {
	return userLocaleList;
}
public void setUserLocaleList(ArrayList<UserLocaleModel> userLocaleList) {
	this.userLocaleList = userLocaleList;
}

}
