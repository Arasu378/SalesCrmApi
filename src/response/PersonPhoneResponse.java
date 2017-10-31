package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.PersonPhoneModel;

public class PersonPhoneResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
private String message;
	@XmlElement(name="PersonPhoneList")
private ArrayList<PersonPhoneModel>personPhoneList=new ArrayList<PersonPhoneModel>();
public PersonPhoneResponse(){
	
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
public ArrayList<PersonPhoneModel> getPersonPhoneList() {
	return personPhoneList;
}
public void setPersonPhoneList(ArrayList<PersonPhoneModel> personPhoneList) {
	this.personPhoneList = personPhoneList;
}

}
