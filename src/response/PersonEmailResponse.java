package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.PersonEmailModel;

public class PersonEmailResponse {
	@XmlElement(name="IsSuccess")
	private boolean isSuccess;
	@XmlElement(name="Message")
	private String message;
	@XmlElement(name="PersonEmailList")
	private ArrayList<PersonEmailModel>personEmailList=new ArrayList<PersonEmailModel>();
	public PersonEmailResponse(){
		
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
	public ArrayList<PersonEmailModel> getPersonEmailList() {
		return personEmailList;
	}
	public void setPersonEmailList(ArrayList<PersonEmailModel> personEmailList) {
		this.personEmailList = personEmailList;
	}
	

}
