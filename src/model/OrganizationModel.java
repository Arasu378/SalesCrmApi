package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class OrganizationModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElement(name="OrganizationId")
	private int organizationId;
	@XmlElement(name="Name")
	private String name;
	@XmlElement(name="PeopleCount")
	private int peopleCount;
	@XmlElement(name="OwnersUserProfileId")
	private int ownersUserProfileId;
	@XmlElement(name="Address")
	private String address;
	@XmlElement(name="CCEmail")
	private String cCEmail;
	@XmlElement(name="CreatedDate")
	private String createdDate;
	@XmlElement(name="ModifiedDate")
	private String modifiedDate;
	@XmlElement(name="CompanyCode")
	private String companyCode;
	@XmlElement(name="OpenDealsCount")
	private int openDealsCount;
	@XmlElement(name="RelatedOpenDealsCount")
	private int relatedOpenDealsCount;
	@XmlElement(name="ClosedDealsCount")
	private int closedDealsCount;
	@XmlElement(name="RelatedClosedDealsCount")
	private int relatedClosedDealsCount;
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
	@XmlElement(name="FilesCount")
	private int filesCount;
	@XmlElement(name="NotesCount")
	private int notesCount;
	@XmlElement(name="FollowersCount")
	private int followersCount;
	@XmlElement(name="WonDealsCount")
	private int wonDealsCount;
	@XmlElement(name="RelatedWonDealsCount")
	private int relatedWonDealsCount;
	@XmlElement(name="LostDealsCount")
	private int lostDealsCount;
	@XmlElement(name="RelatedLostDealsCount")
	private int relatedLostDealsCount;
	@XmlElement(name="ActiveFlag")
	private boolean activeFlag;
	@XmlElement(name="CategoryId")
	private int categoryId;
	@XmlElement(name="PictureId")
	private int pictureId;
	@XmlElement(name="CountryCode")
	private String countryCode;
	@XmlElement(name="FirstChar")
	private String firstChar;
	@XmlElement(name="VisibleTo")
	private int visibleTo;
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
	@XmlElement(name="TimeLineLastActivityTime")
	private String timeLineLastActivityTime;
	@XmlElement(name="TimeLineLastActivityTimeByOwner")
	private String timeLineLastActivityTimeByOwner;
	@XmlElement(name="AddressSubpremise")
	private String addressSubpremise;
	@XmlElement(name="AddressStreetNumber")
	private String addressStreetNumber;
	@XmlElement(name="AddressRoute")
	private String addressRoute;
	@XmlElement(name="AddressSubLocality")
	private String addressSubLocality;
	@XmlElement(name="AddressLocality")
	private String addressLocality;
	@XmlElement(name="AddressAdminAreaLevel1")
	private String addressAdminAreaLevel1;
	@XmlElement(name="AddressAdminAreaLevel2")
	private String addressAdminAreaLevel2;
	@XmlElement(name="AddressCountry")
	private String addressCountry;
	@XmlElement(name="AddressPostalCode")
	private String addressPostalCode;
	@XmlElement(name="AddressFormattedAddress")
	private String addressFormattedAddress;
	@XmlElement(name="OwnerName")
	private String ownerName;
	public OrganizationModel(){
		
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPeopleCount() {
		return peopleCount;
	}
	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}
	public int getOwnersUserProfileId() {
		return ownersUserProfileId;
	}
	public void setOwnersUserProfileId(int ownersUserProfileId) {
		this.ownersUserProfileId = ownersUserProfileId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCCEmail() {
		return cCEmail;
	}
	public void setCCEmail(String cCEmail) {
		this.cCEmail = cCEmail;
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
	public int getRelatedOpenDealsCount() {
		return relatedOpenDealsCount;
	}
	public void setRelatedOpenDealsCount(int relatedOpenDealsCount) {
		this.relatedOpenDealsCount = relatedOpenDealsCount;
	}
	public int getClosedDealsCount() {
		return closedDealsCount;
	}
	public void setClosedDealsCount(int closedDealsCount) {
		this.closedDealsCount = closedDealsCount;
	}
	public int getRelatedClosedDealsCount() {
		return relatedClosedDealsCount;
	}
	public void setRelatedClosedDealsCount(int relatedClosedDealsCount) {
		this.relatedClosedDealsCount = relatedClosedDealsCount;
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
	public int getFilesCount() {
		return filesCount;
	}
	public void setFilesCount(int filesCount) {
		this.filesCount = filesCount;
	}
	public int getNotesCount() {
		return notesCount;
	}
	public void setNotesCount(int notesCount) {
		this.notesCount = notesCount;
	}
	public int getFollowersCount() {
		return followersCount;
	}
	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}
	public int getWonDealsCount() {
		return wonDealsCount;
	}
	public void setWonDealsCount(int wonDealsCount) {
		this.wonDealsCount = wonDealsCount;
	}
	public int getRelatedwonDealsCount() {
		return relatedWonDealsCount;
	}
	public void setRelatedwonDealsCount(int relatedwonDealsCount) {
		this.relatedWonDealsCount = relatedwonDealsCount;
	}
	public int getLostDealsCount() {
		return lostDealsCount;
	}
	public void setLostDealsCount(int lostDealsCount) {
		this.lostDealsCount = lostDealsCount;
	}
	public int getRelatedLostDealsCount() {
		return relatedLostDealsCount;
	}
	public void setRelatedLostDealsCount(int relatedLostDealsCount) {
		this.relatedLostDealsCount = relatedLostDealsCount;
	}
	public boolean getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getPictureId() {
		return pictureId;
	}
	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getFirstChar() {
		return firstChar;
	}
	public void setFirstChar(String firstChar) {
		this.firstChar = firstChar;
	}
	public int getVisibleTo() {
		return visibleTo;
	}
	public void setVisibleTo(int visibleTo) {
		this.visibleTo = visibleTo;
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
	public String getTimeLineLastActivityTime() {
		return timeLineLastActivityTime;
	}
	public void setTimeLineLastActivityTime(String timeLineLastActivityTime) {
		this.timeLineLastActivityTime = timeLineLastActivityTime;
	}
	public String getTimeLineLastActivityTimeByOwner() {
		return timeLineLastActivityTimeByOwner;
	}
	public void setTimeLineLastActivityTimeByOwner(
			String timeLineLastActivityTimeByOwner) {
		this.timeLineLastActivityTimeByOwner = timeLineLastActivityTimeByOwner;
	}
	public String getAddressSubpremise() {
		return addressSubpremise;
	}
	public void setAddressSubpremise(String addressSubpremise) {
		this.addressSubpremise = addressSubpremise;
	}
	public String getAddressStreetNumber() {
		return addressStreetNumber;
	}
	public void setAddressStreetNumber(String addressStreetNumber) {
		this.addressStreetNumber = addressStreetNumber;
	}
	public String getAddressRoute() {
		return addressRoute;
	}
	public void setAddressRoute(String addressRoute) {
		this.addressRoute = addressRoute;
	}
	public String getAddressSubLocality() {
		return addressSubLocality;
	}
	public void setAddressSubLocality(String addressSubLocality) {
		this.addressSubLocality = addressSubLocality;
	}
	public String getAddressLocality() {
		return addressLocality;
	}
	public void setAddressLocality(String addressLocality) {
		this.addressLocality = addressLocality;
	}
	public String getAddressAdminAreaLevel1() {
		return addressAdminAreaLevel1;
	}
	public void setAddressAdminAreaLevel1(String addressAdminAreaLevel1) {
		this.addressAdminAreaLevel1 = addressAdminAreaLevel1;
	}
	public String getAddressAdminAreaLevel2() {
		return addressAdminAreaLevel2;
	}
	public void setAddressAdminAreaLevel2(String addressAdminAreaLevel2) {
		this.addressAdminAreaLevel2 = addressAdminAreaLevel2;
	}
	public String getAddressCountry() {
		return addressCountry;
	}
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	public String getAddressPostalCode() {
		return addressPostalCode;
	}
	public void setAddressPostalCode(String addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
	}
	public String getAddressFormattedAddress() {
		return addressFormattedAddress;
	}
	public void setAddressFormattedAddress(String addressFormattedAddress) {
		this.addressFormattedAddress = addressFormattedAddress;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	

}
