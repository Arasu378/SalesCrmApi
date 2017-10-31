package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.DealModel;

public class DealResponse {
	@XmlElement(name="IsSuccess")
	private boolean isSuccess;
	@XmlElement(name="Message")
	private String message;
	@XmlElement(name="DealList")
	private ArrayList<DealModel>dealList=new ArrayList<DealModel>();
	public DealResponse(){
		
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
	public ArrayList<DealModel> getDealList() {
		return dealList;
	}
	public void setDealList(ArrayList<DealModel> dealList) {
		this.dealList = dealList;
	}
	

}
