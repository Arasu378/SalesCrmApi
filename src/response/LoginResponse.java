package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.LoginModel;

public class LoginResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
private String message;
	@XmlElement(name="LoginModel")
private ArrayList<LoginModel>loginModel=new ArrayList<LoginModel>();
public LoginResponse(){
	
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
public ArrayList<LoginModel> getLoginModel() {
	return loginModel;
}
public void setLoginModel(ArrayList<LoginModel> loginModel) {
	this.loginModel = loginModel;
}

}
