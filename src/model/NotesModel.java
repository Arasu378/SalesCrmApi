package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class NotesModel  implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElement(name="NoteId")
	private int noteId;
	@XmlElement(name="UserProfileId")
	private int userProfileId;
	@XmlElement(name="DealId")
	private int dealId;
	@XmlElement(name="PersonId")
	private int personId;
	@XmlElement(name="OrgId")
	private int orgId;
	@XmlElement(name="Content")
	private String content;
	@XmlElement(name="DateCreated")
	private String dateCreated;
	@XmlElement(name="DateModified")
	private String dateModified;
	@XmlElement(name="ActiveFlag")
	private boolean activeFlag;
	@XmlElement(name="PinnedToDealFlag")
	private boolean pinnedToDealFlag;
	@XmlElement(name="PinnedToPersonFlag")
	private boolean pinnedToPersonFlag;
	@XmlElement(name="PinnedToOrganizationFlag")
	private boolean pinnedToOrganizationFlag;
	@XmlElement(name="LastUpdateUserId")
	private int lastUpdateUserId;
	@XmlElement(name="CompanyId")
	private int companyId;
	public NotesModel(){
		
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public boolean getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public boolean getPinnedToDealFlag() {
		return pinnedToDealFlag;
	}
	public void setPinnedToDealFlag(boolean pinnedToDealFlag) {
		this.pinnedToDealFlag = pinnedToDealFlag;
	}
	public boolean getPinnedToPersonFlag() {
		return pinnedToPersonFlag;
	}
	public void setPinnedToPersonFlag(boolean pinnedToPersonFlag) {
		this.pinnedToPersonFlag = pinnedToPersonFlag;
	}
	public boolean getPinnedToOrganizationFlag() {
		return pinnedToOrganizationFlag;
	}
	public void setPinnedToOrganizationFlag(boolean pinnedToOrganizationFlag) {
		this.pinnedToOrganizationFlag = pinnedToOrganizationFlag;
	}
	public int getLastUpdateUserId() {
		return lastUpdateUserId;
	}
	public void setLastUpdateUserId(int lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	

}
