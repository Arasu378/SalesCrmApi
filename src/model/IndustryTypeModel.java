package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class IndustryTypeModel  implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElement(name="IndustryTypeId")
	private int industryTypeId;
	@XmlElement(name="TypeName")
	private String typeName;
	@XmlElement(name="IsActive")
	private boolean isActive;
	@XmlElement(name="CreatedDate")
	private String createdDate;
	@XmlElement(name="ModifiedDate")
	private String modifiedDate;
	public IndustryTypeModel(){
		
	}
	public int getIndustryTypeId() {
		return industryTypeId;
	}
	public void setIndustryTypeId(int industryTypeId) {
		this.industryTypeId = industryTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
