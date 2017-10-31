package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class PersonEmailModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElement(name="PersonEmailId")
private int personEmailId;
	@XmlElement(name="Label")
private String label;
	@XmlElement(name="Value")
private String value;
	@XmlElement(name="Primary")
private boolean primary;
	@XmlElement(name="CreatedDate")
private String createdDate;
	@XmlElement(name="ModifiedDate")
private String modifiedDate;
	@XmlElement(name="PersonId")
private int personId;
public PersonEmailModel(){
	
}
public int getPersonEmailId() {
	return personEmailId;
}
public void setPersonEmailId(int personEmailId) {
	this.personEmailId = personEmailId;
}
public String getLabel() {
	return label;
}
public void setLabel(String label) {
	this.label = label;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
public boolean getPrimary() {
	return primary;
}
public void setPrimary(boolean primary) {
	this.primary = primary;
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
public int getPersonId() {
	return personId;
}
public void setPersonId(int personId) {
	this.personId = personId;
}

}
