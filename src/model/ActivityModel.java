package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class ActivityModel  implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElement(name="ActivityId")
	private int activityId;
	@XmlElement(name="CompanyId")
	private int companyId;
	@XmlElement(name="UserProfileId")
	private int userProfileId;
	@XmlElement(name="Done")
	private boolean done;
	@XmlElement(name="Type")
	private String type;
	@XmlElement(name="ReferenceType")
	private String referenceType;
	@XmlElement(name="ReferenceId")
	private String referenceId;
	@XmlElement(name="DueDate")
	private String dueDate;
	@XmlElement(name="DueTime")
	private String dueTime;
	@XmlElement(name="Duration")
	private String duration;
	@XmlElement(name="AddTime")
	private String addTime;
	@XmlElement(name="MarkedAsDoneTime")
	private String markedAsDoneTime;
	@XmlElement(name="Subject")
	private String subject;
	@XmlElement(name="OrgId")
	private int orgId;
	@XmlElement(name="PersonId")
	private int personId;
	@XmlElement(name="DealId")
	private int dealId;
	@XmlElement(name="ActiveFlag")
	private boolean activeFlag;
	@XmlElement(name="UpdateTime")
	private String updateTime;
	@XmlElement(name="GCalEventId")
	private String gCalEventId;
	@XmlElement(name="GoogleCalendarId")
	private String googleCalendarId;
	@XmlElement(name="GoogleCalendarETag")
	private String googleCalendarETag;
	@XmlElement(name="Note")
	private String note;
	@XmlElement(name="CreatedByUserProfileId")
	private int createdByUserProfileId;
	@XmlElement(name="Participants")
	private String participants;
	@XmlElement(name="OrgName")
	private String orgName;
	@XmlElement(name="PersonName")
	private String personName;
	@XmlElement(name="DealTitle")
	private String dealTitle;
	@XmlElement(name="OwnerName")
	private String ownerName;
	@XmlElement(name="PersonDropBoxBcc")
	private String personDropBoxBcc;
	@XmlElement(name="DealDropBoxBcc")
	private String dealDropBoxBcc;
	@XmlElement(name="AssignedToUserProfileId")
	private int assignedToUserProfileId;
	
	public ActivityModel(){
		
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public boolean getDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDueTime() {
		return dueTime;
	}

	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getMarkedAsDoneTime() {
		return markedAsDoneTime;
	}

	public void setMarkedAsDoneTime(String markedAsDoneTime) {
		this.markedAsDoneTime = markedAsDoneTime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getDealId() {
		return dealId;
	}

	public void setDealId(int dealId) {
		this.dealId = dealId;
	}

	public boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getGCalEventId() {
		return gCalEventId;
	}

	public void setGCalEventId(String gCalEventId) {
		this.gCalEventId = gCalEventId;
	}

	public String getGoogleCalendarId() {
		return googleCalendarId;
	}

	public void setGoogleCalendarId(String googleCalendarId) {
		this.googleCalendarId = googleCalendarId;
	}

	public String getGoogleCalendarETag() {
		return googleCalendarETag;
	}

	public void setGoogleCalendarETag(String googleCalendarETag) {
		this.googleCalendarETag = googleCalendarETag;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getCreatedByUserProfileId() {
		return createdByUserProfileId;
	}

	public void setCreatedByUserProfileId(int createdByUserProfileId) {
		this.createdByUserProfileId = createdByUserProfileId;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getDealTitle() {
		return dealTitle;
	}

	public void setDealTitle(String dealTitle) {
		this.dealTitle = dealTitle;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPersonDropBoxBcc() {
		return personDropBoxBcc;
	}

	public void setPersonDropBoxBcc(String personDropBoxBcc) {
		this.personDropBoxBcc = personDropBoxBcc;
	}

	public String getDealDropBoxBcc() {
		return dealDropBoxBcc;
	}

	public void setDealDropBoxBcc(String dealDropBoxBcc) {
		this.dealDropBoxBcc = dealDropBoxBcc;
	}

	public int getAssignedToUserProfileId() {
		return assignedToUserProfileId;
	}

	public void setAssignedToUserProfileId(int assignedToUserProfileId) {
		this.assignedToUserProfileId = assignedToUserProfileId;
	}
	

}
