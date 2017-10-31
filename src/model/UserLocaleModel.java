package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class UserLocaleModel implements Serializable{
	private static final long serialVersionUID = 1L;
@XmlElement(name="UserLocaleId")
private int userLocaleId;
@XmlElement(name="LocaleCode")
private String localeCode;
@XmlElement(name="UserLocale")
private String userLocale;
@XmlElement(name="IsActive")
private boolean isActive;
@XmlElement(name="CreatedDate")
private String createdDate;
@XmlElement(name="ModifiedDate")
private String modifiedDate;
public UserLocaleModel(){
	
}
public int getUserLocaleId() {
	return userLocaleId;
}
public void setUserLocaleId(int userLocaleId) {
	this.userLocaleId = userLocaleId;
}
public String getLocaleCode() {
	return localeCode;
}
public void setLocaleCode(String localeCode) {
	this.localeCode = localeCode;
}
public String getUserLocale() {
	return userLocale;
}
public void setUserLocale(String userLocale) {
	this.userLocale = userLocale;
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

}
