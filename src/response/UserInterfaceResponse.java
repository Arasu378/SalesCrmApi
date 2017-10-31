package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.UserInterfaceModel;

public class UserInterfaceResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
private String message;
	@XmlElement(name="UserInterfaceList")
private ArrayList<UserInterfaceModel>userInterfaceList= new ArrayList<UserInterfaceModel>();
public UserInterfaceResponse(){
	
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
public ArrayList<UserInterfaceModel> getUserInterfaceList() {
	return userInterfaceList;
}
public void setUserInterfaceList(ArrayList<UserInterfaceModel> userInterfaceList) {
	this.userInterfaceList = userInterfaceList;
}

}
