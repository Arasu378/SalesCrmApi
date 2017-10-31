package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.EmailIntegrationModel;

public class EmailIntegrationResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
private String message;
	@XmlElement(name="EmailIntegrationList")
private ArrayList<EmailIntegrationModel>emailIntegrationList=new ArrayList<EmailIntegrationModel>();
public EmailIntegrationResponse(){
	
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
public ArrayList<EmailIntegrationModel> getEmailIntegrationList() {
	return emailIntegrationList;
}
public void setEmailIntegrationList(
		ArrayList<EmailIntegrationModel> emailIntegrationList) {
	this.emailIntegrationList = emailIntegrationList;
}

}
