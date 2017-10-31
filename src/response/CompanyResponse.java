package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.CompanyModel;

public class CompanyResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
private String message;
	@XmlElement(name="CompanyList")
private ArrayList<CompanyModel>companyList=new ArrayList<CompanyModel>();
public CompanyResponse(){
	
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
public ArrayList<CompanyModel> getCompanyList() {
	return companyList;
}
public void setCompanyList(ArrayList<CompanyModel> companyList) {
	this.companyList = companyList;
}

}
