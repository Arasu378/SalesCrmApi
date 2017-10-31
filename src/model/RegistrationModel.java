package model;

import javax.xml.bind.annotation.XmlElement;

public class RegistrationModel {
	@XmlElement(name="RegistrationId")
private int registrationId;
	@XmlElement(name="CompanyCode")
private String companyCode;
	@XmlElement(name="EmailAddress")
private String emailAddress;
	@XmlElement(name="UserPassword")
private String userPassword;
	@XmlElement(name="UserName")
private String userName;
	@XmlElement(name="CompanyName")
private String companyName;
	@XmlElement(name="IndustryTypeId")
private int industryTypeId;
	@XmlElement(name="LastLoginOn")
private String lastLoginOn;
	@XmlElement(name="IsActive")
private boolean isActive;
	@XmlElement(name="CreatedDate")
private String createdDate;
	@XmlElement(name="ModifiedDate")
private String modifiedDate;
	@XmlElement(name="UserProfileId")
	private int userProfileId;
	@XmlElement(name="TimeZone")
	private String timeZone;
	@XmlElement(name="UserLocaleId")
	private int userLocaleId;
	@XmlElement(name="LanguageId")
	private int languageId;
	@XmlElement(name="CurrencyId")
	private int currencyId;
	public RegistrationModel(){
		
	}
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getIndustryTypeId() {
		return industryTypeId;
	}
	public void setIndustryTypeId(int industryTypeId) {
		this.industryTypeId = industryTypeId;
	}
	public String getLastLoginOn() {
		return lastLoginOn;
	}
	public void setLastLoginOn(String lastLoginOn) {
		this.lastLoginOn = lastLoginOn;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
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
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public int getUserLocaleId() {
		return userLocaleId;
	}
	public void setUserLocaleId(int userLocaleId) {
		this.userLocaleId = userLocaleId;
	}
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	
	

}
