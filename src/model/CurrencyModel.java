package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class CurrencyModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement(name="CurrencyId")
	private int currencyId;
	@XmlElement(name="CurrencyCode")
	private String currencyCode;
	@XmlElement(name="CurrencyName")
	private String currencyName;
	@XmlElement(name="IsActive")
	private boolean isActive;
	@XmlElement(name="CreatedDate")
	private String createdDate;
	@XmlElement(name="ModifiedDate")
	private String modifiedDate;
	public CurrencyModel(){
		
	}
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public boolean getisActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	

}
