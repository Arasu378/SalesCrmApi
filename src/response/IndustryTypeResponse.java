package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.IndustryTypeModel;

public class IndustryTypeResponse {
	@XmlElement(name="IsSuccess")
	private boolean isSuccess;
	@XmlElement(name="Message")
	private String message;
	@XmlElement(name="IndustryType")
	private ArrayList<IndustryTypeModel>industryType=new ArrayList<IndustryTypeModel>();
	public IndustryTypeResponse(){
		
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
	public ArrayList<IndustryTypeModel> getIndustryType() {
		return industryType;
	}
	public void setIndustryType(ArrayList<IndustryTypeModel> industryType) {
		this.industryType = industryType;
	}
	

}
