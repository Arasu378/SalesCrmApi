package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class ActivityTypeModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement(name="ActivityTypeId")
	private int activityTypeId;
	@XmlElement(name="OrderNr")
	private int orderNr;
	@XmlElement(name="Name")
	private String name;
	@XmlElement(name="KeyString")
	private String keyString;
	@XmlElement(name="IconKey")
	private String iconKey;
	@XmlElement(name="ActiveFlag")
	private boolean activeFlag;
	@XmlElement(name="Color")
	private String color;
	@XmlElement(name="IsCustomFlag")
	private boolean isCustomFlag;
	@XmlElement(name="DateCreated")
	private String dateCreated;
	@XmlElement(name="DateModified")
	private String dateModified;
	@XmlElement(name="UserProfileId")
	private int userProfileId;
	public ActivityTypeModel(){
		
	}
	
	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public int getActivityTypeId() {
		return activityTypeId;
	}
	public void setActivityTypeId(int activityTypeId) {
		this.activityTypeId = activityTypeId;
	}
	public int getOrderNr() {
		return orderNr;
	}
	public void setOrderNr(int orderNr) {
		this.orderNr = orderNr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKeyString() {
		return keyString;
	}
	public void setKeyString(String keyString) {
		this.keyString = keyString;
	}
	public String getIconKey() {
		return iconKey;
	}
	public void setIconKey(String iconKey) {
		this.iconKey = iconKey;
	}
	public boolean getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean getIsCustomFlag() {
		return isCustomFlag;
	}
	public void setIsCustomFlag(boolean isCustomFlag) {
		this.isCustomFlag = isCustomFlag;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	
	
}
