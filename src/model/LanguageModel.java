package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class LanguageModel implements Serializable{
	private static final long serialVersionUID = 1L;
@XmlElement(name="LanguageId")
private int languageId;
@XmlElement(name="LanguageCultureName")
private String languageCultureName;
@XmlElement(name="LanguageName")
private String languageName;
@XmlElement(name="IsActive")
private boolean isActive;
@XmlElement(name="CreatedDate")
private String createdDate;
@XmlElement(name="ModifiedDate")
private String modifiedDate;
public LanguageModel(){
	
}
public int getLanguageId() {
	return languageId;
}
public void setLanguageId(int languageId) {
	this.languageId = languageId;
}
public String getLanguageCultureName() {
	return languageCultureName;
}
public void setLanguageCultureName(String languageCultureName) {
	this.languageCultureName = languageCultureName;
}
public String getLanguageName() {
	return languageName;
}
public void setLanguageName(String languageName) {
	this.languageName = languageName;
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
