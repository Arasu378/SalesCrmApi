package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.CurrencyModel;

public class CurrencyResponse {
	@XmlElement(name="IsSuccess")
	public boolean isSuccess;
	@XmlElement(name="Message")
	public String message;
	@XmlElement(name="CurrencyModel")
	public ArrayList<CurrencyModel>currencyModel=new ArrayList<CurrencyModel>();
	public CurrencyResponse(){
		
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
	public ArrayList<CurrencyModel> getCurrencyModel() {
		return currencyModel;
	}
	public void setCurrencyModel(ArrayList<CurrencyModel> currencyModel) {
		this.currencyModel = currencyModel;
	}
	
 
	

}
