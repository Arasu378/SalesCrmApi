package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class PipeLineModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElement(name="PipeLineId")
	private int pipeLineId;
	@XmlElement(name="Name")
	private String name;
	@XmlElement(name="UserProfileId")
	private int userProfileId;
	@XmlElement(name="DateCreated")
	private String dateCreated;
	@XmlElement(name="DateModified")
	private String dateModified;
	@XmlElement(name="OrderNr")
	private int orderNr;
	@XmlElement(name="IsActive")
	private boolean isActive;
	@XmlElement(name="IsSelected")
	private boolean isSelected;
	@XmlElement(name="IsDealProbability")
	private boolean isDealProbability;
	@XmlElement(name="UrlTitle")
	private String urlTitle;
	public PipeLineModel(){
		
	}
	public int getPipeLineId() {
		return pipeLineId;
	}
	public void setPipeLineId(int pipeLineId) {
		this.pipeLineId = pipeLineId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
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
	public int getOrderNr() {
		return orderNr;
	}
	public void setOrderNr(int orderNr) {
		this.orderNr = orderNr;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean active) {
		this.isActive = active;
	}
	public boolean getIsSelected() {
		return isSelected;
	}
	public void setIsSelected(boolean selected) {
		this.isSelected = selected;
	}
	public boolean getIsDealProbability() {
		return isDealProbability;
	}
	public void setIsDealProbability(boolean dealProbability) {
		this.isDealProbability = dealProbability;
	}
	public String getUrlTitle() {
		return urlTitle;
	}
	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}
	

}
