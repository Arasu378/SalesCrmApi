package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class DealModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement(name="DealId")
	private int dealId;
	@XmlElement(name="Title")
	private String title;
	@XmlElement(name="Status")
	private String status;
	@XmlElement(name="Value")
	private int value;
	@XmlElement(name="Currency")
	private String currency;
	@XmlElement(name="StageId")
	private int stageId;
	@XmlElement(name="PipeLineId")
	private int pipeLineId;
	@XmlElement(name="UserProfileId")
	private int userProfileId;
	@XmlElement(name="PersonId")
	private int personId;
	@XmlElement(name="OrganizationId")
	private int organizationId;
	@XmlElement(name="AddTime")
	private String addTime;
	@XmlElement(name="UpdateTime")
	private String updateTime;
	@XmlElement(name="StageChangeTime")
	private String stageChangeTime;
	@XmlElement(name="Active")
	private boolean active;
	@XmlElement(name="Deleted")
	private boolean deleted;
	@XmlElement(name="Probability")
	private String probability;
	@XmlElement(name="NextActivityDate")
	private String nextActivityDate;
	@XmlElement(name="NextActivityTime")
	private String nextActivityTime;
	@XmlElement(name="NextActivityId")
	private int nextActivityId;
	@XmlElement(name="LastActivityId")
	private int lastActivityId;
	@XmlElement(name="LastActivityDate")
	private String lastActivityDate;
	@XmlElement(name="LostReason")
	private String lostReason;
	@XmlElement(name="VisibleTo")
	private int visibleTo;
	@XmlElement(name="CloseTime")
	private String closeTime;
	@XmlElement(name="WonTime")
	private String wonTime;
	@XmlElement(name="FirstWonTime")
	private String firstWonTime;
	@XmlElement(name="LostTime")
	private String lostTime;
	@XmlElement(name="ProductsCount")
	private int productsCount;
	@XmlElement(name="FilesCount")
	private int filesCount;
	@XmlElement(name="NotesCount")
	private int notesCount;
	@XmlElement(name="FollowersCount")
	private int followersCount;
	@XmlElement(name="EmailMessagesCount")
	private int emailMessagesCount;
	@XmlElement(name="ActivitiesCount")
	private int activitiesCount;
	@XmlElement(name="DoneActivitiesCount")
	private int doneActivitiesCount;
	@XmlElement(name="UndoneActivitiesCount")
	private int undoneActivitiesCount;
	@XmlElement(name="ReferenceActivitiesCount")
	private int referenceActivitiesCount;
	@XmlElement(name="ParticipantsCount")
	private int participantsCount;
	@XmlElement(name="ExpectedCloseDate")
	private String expectedCloseDate;
	@XmlElement(name="LastIncomingMailTime")
	private String lastIncomingMailTime;
	@XmlElement(name="LastOutgoingMailTime")
	private String lastOutgoingMailTime;
	@XmlElement(name="StageOrderNr")
	private int stageOrderNr;
	@XmlElement(name="PersonName")
	private String personName;
	@XmlElement(name="OrgName")
	private String orgName;
	@XmlElement(name="NextActivitySubject")
	private String nextActivitySubject;
	@XmlElement(name="NextActivityType")
	private String nextActivityType;
	@XmlElement(name="NextActivityDuration")
	private String nextActivityDuration;
	@XmlElement(name="NextActivityNote")
	private String nextActivityNote;
	@XmlElement(name="FormattedValue")
	private String formattedValue;
	@XmlElement(name="RottenTime")
	private String rottenTime;
	@XmlElement(name="WeightedValue")
	private int weightedValue;
	@XmlElement(name="FormattedWeightedValue")
	private String formattedWeightedValue;
	@XmlElement(name="OwnerName")
	private String ownerName;
	@XmlElement(name="CCEmail")
	private String cCEmail;
	@XmlElement(name="OrgHidden")
	private boolean orgHidden;
	@XmlElement(name="PersonHidden")
	private boolean personHidden;
	@XmlElement(name="PeopleCount")
	private int peopleCount;
	@XmlElement(name="OpenDealsCount")
	private int openDealsCount;
	
	@XmlElement(name="CompanyCode")
	private String companyCode;
	public DealModel(){
		
	}

	
	public String getCompanyCode() {
		return companyCode;
	}


	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}


	public int getOpenDealsCount() {
		return openDealsCount;
	}


	public void setOpenDealsCount(int openDealsCount) {
		this.openDealsCount = openDealsCount;
	}


	public int getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}

	public int getDealId() {
		return dealId;
	}

	public void setDealId(int dealId) {
		this.dealId = dealId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getStageId() {
		return stageId;
	}

	public void setStageId(int stageId) {
		this.stageId = stageId;
	}

	public int getPipeLineId() {
		return pipeLineId;
	}

	public void setPipeLineId(int pipeLineId) {
		this.pipeLineId = pipeLineId;
	}

	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getStageChangeTime() {
		return stageChangeTime;
	}

	public void setStageChangeTime(String stageChangeTime) {
		this.stageChangeTime = stageChangeTime;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getProbability() {
		return probability;
	}

	public void setProbability(String probability) {
		this.probability = probability;
	}

	public String getNextActivityDate() {
		return nextActivityDate;
	}

	public void setNextActivityDate(String nextActivityDate) {
		this.nextActivityDate = nextActivityDate;
	}

	public String getNextActivityTime() {
		return nextActivityTime;
	}

	public void setNextActivityTime(String nextActivityTime) {
		this.nextActivityTime = nextActivityTime;
	}

	public int getNextActivityId() {
		return nextActivityId;
	}

	public void setNextActivityId(int nextActivityId) {
		this.nextActivityId = nextActivityId;
	}

	public int getLastActivityId() {
		return lastActivityId;
	}

	public void setLastActivityId(int lastActivityId) {
		this.lastActivityId = lastActivityId;
	}

	public String getLastActivityDate() {
		return lastActivityDate;
	}

	public void setLastActivityDate(String lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	public String getLostReason() {
		return lostReason;
	}

	public void setLostReason(String lostReason) {
		this.lostReason = lostReason;
	}

	public int getVisibleTo() {
		return visibleTo;
	}

	public void setVisibleTo(int visibleTo) {
		this.visibleTo = visibleTo;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getWonTime() {
		return wonTime;
	}

	public void setWonTime(String wonTime) {
		this.wonTime = wonTime;
	}

	public String getFirstWonTime() {
		return firstWonTime;
	}

	public void setFirstWonTime(String firstWonTime) {
		this.firstWonTime = firstWonTime;
	}

	public String getLostTime() {
		return lostTime;
	}

	public void setLostTime(String lostTime) {
		this.lostTime = lostTime;
	}

	public int getProductsCount() {
		return productsCount;
	}

	public void setProductsCount(int productsCount) {
		this.productsCount = productsCount;
	}

	public int getFilesCount() {
		return filesCount;
	}

	public void setFilesCount(int filesCount) {
		this.filesCount = filesCount;
	}

	public int getNotescount() {
		return notesCount;
	}

	public void setNotescount(int notesCount) {
		this.notesCount = notesCount;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public int getEmailMessagesCount() {
		return emailMessagesCount;
	}

	public void setEmailMessagesCount(int emailMessagesCount) {
		this.emailMessagesCount = emailMessagesCount;
	}

	public int getActivitiesCount() {
		return activitiesCount;
	}

	public void setActivitiesCount(int activitiesCount) {
		this.activitiesCount = activitiesCount;
	}

	public int getDoneActivitiesCount() {
		return doneActivitiesCount;
	}

	public void setDoneActivitiesCount(int doneActivitiesCount) {
		this.doneActivitiesCount = doneActivitiesCount;
	}

	public int getUndoneActivitiesCount() {
		return undoneActivitiesCount;
	}

	public void setUndoneActivitiesCount(int undoneActivitiesCount) {
		this.undoneActivitiesCount = undoneActivitiesCount;
	}

	public int getReferenceActivitiesCount() {
		return referenceActivitiesCount;
	}

	public void setReferenceActivitiesCount(int referenceActivitiesCount) {
		this.referenceActivitiesCount = referenceActivitiesCount;
	}

	public int getParticipantsCount() {
		return participantsCount;
	}

	public void setParticipantsCount(int participantsCount) {
		this.participantsCount = participantsCount;
	}

	public String getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public void setExpectedCloseDate(String expectedCloseDate) {
		this.expectedCloseDate = expectedCloseDate;
	}

	public String getLastIncomingMailTime() {
		return lastIncomingMailTime;
	}

	public void setLastIncomingMailTime(String lastIncomingMailTime) {
		this.lastIncomingMailTime = lastIncomingMailTime;
	}

	public String getLastOutgoingMailTime() {
		return lastOutgoingMailTime;
	}

	public void setLastOutgoingMailTime(String lastOutgoingMailTime) {
		this.lastOutgoingMailTime = lastOutgoingMailTime;
	}

	public int getStageOrderNr() {
		return stageOrderNr;
	}

	public void setStageOrderNr(int stageOrderNr) {
		this.stageOrderNr = stageOrderNr;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getNextActivitySubject() {
		return nextActivitySubject;
	}

	public void setNextActivitySubject(String nextActivitySubject) {
		this.nextActivitySubject = nextActivitySubject;
	}

	public String getNextActivityType() {
		return nextActivityType;
	}

	public void setNextActivityType(String nextActivityType) {
		this.nextActivityType = nextActivityType;
	}

	public String getNextActivityDuration() {
		return nextActivityDuration;
	}

	public void setNextActivityDuration(String nextActivityDuration) {
		this.nextActivityDuration = nextActivityDuration;
	}

	public String getNextActivityNote() {
		return nextActivityNote;
	}

	public void setNextActivityNote(String nextActivityNote) {
		this.nextActivityNote = nextActivityNote;
	}

	public String getFormattedValue() {
		return formattedValue;
	}

	public void setFormattedValue(String formattedValue) {
		this.formattedValue = formattedValue;
	}

	public String getRottenTime() {
		return rottenTime;
	}

	public void setRottenTime(String rottenTime) {
		this.rottenTime = rottenTime;
	}

	public int getWeightedValue() {
		return weightedValue;
	}

	public void setWeightedValue(int weightedValue) {
		this.weightedValue = weightedValue;
	}

	public String getFormattedWeightedValue() {
		return formattedWeightedValue;
	}

	public void setFormattedWeightedValue(String formattedWeightedValue) {
		this.formattedWeightedValue = formattedWeightedValue;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getcCEmail() {
		return cCEmail;
	}

	public void setcCEmail(String cCEmail) {
		this.cCEmail = cCEmail;
	}

	public boolean getOrgHidden() {
		return orgHidden;
	}

	public void setOrgHidden(boolean orgHidden) {
		this.orgHidden = orgHidden;
	}

	public boolean getPersonHidden() {
		return personHidden;
	}

	public void setPersonHidden(boolean personHidden) {
		this.personHidden = personHidden;
	}
	
}
