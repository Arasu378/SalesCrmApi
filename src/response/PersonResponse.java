package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.PersonModel;

public class PersonResponse {
	@XmlElement(name="IsSuccess")
	private boolean isSuccess;
	@XmlElement(name="Message")
	private String message;
	@XmlElement(name="PersonList")
	private ArrayList<PersonModel>personList=new ArrayList<PersonModel>();
	public PersonResponse(){
		
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
	public ArrayList<PersonModel> getPersonList() {
		return personList;
	}
	public void setPersonList(ArrayList<PersonModel> personList) {
		this.personList = personList;
	}
	

}
