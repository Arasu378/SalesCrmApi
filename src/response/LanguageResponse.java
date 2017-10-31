package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.LanguageModel;

public class LanguageResponse {
@XmlElement(name="IsSuccess")
private boolean isSuccess;
@XmlElement(name="Message")
private String message;
@XmlElement(name="LanguageList")
private ArrayList<LanguageModel>languageList=new ArrayList<LanguageModel>();
public LanguageResponse(){
	
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
public ArrayList<LanguageModel> getLanguageList() {
	return languageList;
}
public void setLanguageList(ArrayList<LanguageModel> languageList) {
	this.languageList = languageList;
}


}
