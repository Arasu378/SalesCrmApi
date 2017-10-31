package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlParameter;

public class PersonModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElement(name="PersonId")
	private int personId;
	@XmlElement(name="UserName")
	private String userName;
	@XmlElement(name="CreatedDate")
	private String createdDate;
	@XmlElement(name="ModifiedDate")
	private String modifiedDate;
	@XmlElement(name="UserProfileId")
	private int userProfileId;
	@XmlElement(name="CompanyCode")
	private String companyCode;
	@XmlElement(name="OrgId")
	private int orgId;
	@XmlElement(name="Name")
	private String name;
	@XmlElement(name="FirstName")
	private String firstName;
	@XmlElement(name="LastName")
	private String lastName;
	@XmlElement(name="OpenDealsCount")
	private int openDealsCount;
	@XmlElement(name="RelatedOpenDealsCount")
	private int relatedOpenDealsCount;
	@XmlElement(name="ParticipantOpenDealsCount")
	private int participantOpenDealsCount;
	@XmlElement(name="ParticipantsClosedDealsCount")
	private int participantsClosedDealsCount;
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
	@XmlElement(name="FirstChar")
	private String firstChar;
	@XmlElement(name="VisibleTo")
	private int visibleTo;
	@XmlElement(name="PictureId")
	private int pictureId;
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
	@XmlElement(name="LastIncomingMailTime")
	private String lastIncomingMailTime;
	@XmlElement(name="LastOutgoingMailTime")
	private String lastOutgoingMailTime;
	@XmlElement(name="PostalAddress")
	private String postalAddress;
	@XmlElement(name="PostalAddressSubpremise")
	private String postalAddressSubpremise;
	@XmlElement(name="PostalAddressStreetNumber")
	private String postalAddressStreetNumber;
	@XmlElement(name="PostalAddressRoute")
	private String postalAddressRoute;
	@XmlElement(name="PostalAddressSubLocality")
	private String postalAddressSubLocality;
	@XmlElement(name="PostalAddressLocality")
	private String postalAddressLocality;
	@XmlElement(name="PostalAddressAdminAreaLevel1")
	private String postalAddressAdminAreaLevel1;
	@XmlElement(name="PostalAddressAdminAreaLevel2")
	private String postalAddressAdminAreaLevel2;
	@XmlElement(name="PostalAddressCountry")
	private String postalAddressCountry;
	@XmlElement(name="PostalAddressPostalCode")
	private String postalAddressPostalCode;
	@XmlElement(name="PostalAdressFormattedAddress")
	private String postalAdressFormattedAddress;
	@XmlElement(name="OrgName")
	private String orgName;
	@XmlElement(name="CCEmail")
	private String cCEmail;
	@XmlElement(name="PostalAddressFormattedAddress")
	private String postalAddressFormattedAddress;
	@XmlElement(name="ownerName")
	private String ownerName;
	@XmlElement(name="PersonPhoneList")
	private ArrayList<PersonPhoneModel>personPhoneList=new ArrayList<PersonPhoneModel>();
	@XmlElement(name="PersonEmailList")
	private ArrayList<PersonEmailModel>personEmailList=new ArrayList<PersonEmailModel>();
	@XmlElement(name="Label")
	private String label;
	@XmlElement(name="Value")
	private String value;
	@XmlElement(name="Primary")
	private boolean primary;
	
	
	public PersonModel(){
		
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

	public ArrayList<PersonPhoneModel> getPersonPhoneList() {
		return personPhoneList;
	}

	public void setPersonPhoneList(ArrayList<PersonPhoneModel> personPhoneList) {
		this.personPhoneList = personPhoneList;
	}

	public ArrayList<PersonEmailModel> getPersonEmailList() {
		return personEmailList;
	}

	public void setPersonEmailList(ArrayList<PersonEmailModel> personEmailList) {
		this.personEmailList = personEmailList;
	}

	public String getPostalAddressFormatAddress() {
		return postalAddressFormattedAddress;
	}

	public void setPostalAddressFormatAddress(String postalAddressFormatAddress) {
		this.postalAddressFormattedAddress = postalAddressFormatAddress;
	}

	public int getPersonId() {
		return personId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode2) {
		this.companyCode = companyCode2;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public int getParticipantOpenDealsCount() {
		return participantOpenDealsCount;
	}

	public void setParticipantOpenDealsCount(int participantOpenDealsCount) {
		this.participantOpenDealsCount = participantOpenDealsCount;
	}

	public int getParticipantsClosedDealsCount() {
		return participantsClosedDealsCount;
	}

	public void setParticipantsClosedDealsCount(int participantsClosedDealsCount) {
		this.participantsClosedDealsCount = participantsClosedDealsCount;
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

	public int getRelatedWonDealsCount() {
		return relatedWonDealsCount;
	}

	public void setRelatedWonDealsCount(int relatedWonDealsCount) {
		this.relatedWonDealsCount = relatedWonDealsCount;
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

	public int getPictureId() {
		return pictureId;
	}

	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
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

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getPostalAddressSubpremise() {
		return postalAddressSubpremise;
	}

	public void setPostalAddressSubpremise(String postalAddressSubpremise) {
		this.postalAddressSubpremise = postalAddressSubpremise;
	}

	public String getPostalAddressStreetNumber() {
		return postalAddressStreetNumber;
	}

	public void setPostalAddressStreetNumber(String postalAddressStreetNumber) {
		this.postalAddressStreetNumber = postalAddressStreetNumber;
	}

	public String getPostalAddressRoute() {
		return postalAddressRoute;
	}

	public void setPostalAddressRoute(String postalAddressRoute) {
		this.postalAddressRoute = postalAddressRoute;
	}

	public String getPostalAddressSubLocality() {
		return postalAddressSubLocality;
	}

	public void setPostalAddressSubLocality(String postalAddressSubLocality) {
		this.postalAddressSubLocality = postalAddressSubLocality;
	}

	public String getPostalAddressLocality() {
		return postalAddressLocality;
	}

	public void setPostalAddressLocality(String postalAddressLocality) {
		this.postalAddressLocality = postalAddressLocality;
	}

	public String getPostalAddressAdminAreaLevel1() {
		return postalAddressAdminAreaLevel1;
	}

	public void setPostalAddressAdminAreaLevel1(String postalAddressAdminAreaLevel1) {
		this.postalAddressAdminAreaLevel1 = postalAddressAdminAreaLevel1;
	}

	public String getPostalAddressAdminAreaLevel2() {
		return postalAddressAdminAreaLevel2;
	}

	public void setPostalAddressAdminAreaLevel2(String postalAddressAdminAreaLevel2) {
		this.postalAddressAdminAreaLevel2 = postalAddressAdminAreaLevel2;
	}

	public String getPostalAddressCountry() {
		return postalAddressCountry;
	}

	public void setPostalAddressCountry(String postalAddressCountry) {
		this.postalAddressCountry = postalAddressCountry;
	}

	public String getPostalAddressPostalCode() {
		return postalAddressPostalCode;
	}

	public void setPostalAddressPostalCode(String postalAddressPostalCode) {
		this.postalAddressPostalCode = postalAddressPostalCode;
	}

	public String getPostalAdressFormattedAddress() {
		return postalAdressFormattedAddress;
	}

	public void setPostalAdressFormattedAddress(String postalAdressFormattedAddress) {
		this.postalAdressFormattedAddress = postalAdressFormattedAddress;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getCCEmail() {
		return cCEmail;
	}

	public void setCCEmail(String cCEmail) {
		this.cCEmail = cCEmail;
	}
	
	

}
