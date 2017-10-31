package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.LoginModel;
import model.RegistrationModel;

public class RegistrationResponse {
	@XmlElement(name="IsSuccess")
	private boolean isSuccess;
	@XmlElement(name="Message")
	private String message;
	@XmlElement(name="RegistrationList")
	private ArrayList<RegistrationModel>registrationList=new ArrayList<RegistrationModel>();
	@XmlElement(name="LoginModel")
private ArrayList<LoginModel>loginModel=new ArrayList<LoginModel>();
	public RegistrationResponse(){
		
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
	public ArrayList<RegistrationModel> getRegistrationList() {
		return registrationList;
	}
	public void setRegistrationList(ArrayList<RegistrationModel> registrationList) {
		this.registrationList = registrationList;
	}
	public ArrayList<LoginModel> getLoginModel() {
		return loginModel;
	}
	public void setLoginModel(ArrayList<LoginModel> loginModel) {
		this.loginModel = loginModel;
	}
	

}
