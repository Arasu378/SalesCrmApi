package model;

import javax.xml.bind.annotation.XmlElement;

public class LoginModel {
	@XmlElement(name="UserEmail")
	private String userEmail;
	@XmlElement(name="Password")
	private String password;
	@XmlElement(name="UserProfileId")
private int userProfileId;
	@XmlElement(name="CompanyId")
private int companyId;
	@XmlElement(name="CompanyCode")
private String companyCode;
	@XmlElement(name="CompanyName")
private String companyName;
	@XmlElement(name="ConnectionId")
private int connectionId;
	@XmlElement(name="IsConnectedToMailChimpAccount")
private boolean isConnectedToMailChimpAccount;
	@XmlElement(name="MailChimpAccountEmail")
private String mailChimpAccountEmail;
	@XmlElement(name="EmailIntegrationId")
private int emailIntegrationId;
	@XmlElement(name="AlternativeEmailAddress")
private String alternativeEmailAddress;
	@XmlElement(name="IsMyLinkedEmailsShared")
private boolean isMyLinkedEmailsShared;
	@XmlElement(name="IsMyEmailConversationsPrivate")
private boolean isMyEmailConversationsPrivate;
	@XmlElement(name="IsLinkMyEmailManually")
private boolean isLinkMyEmailManually;
	@XmlElement(name="IsEmailLinkWithDeals")
private boolean isEmailLinkWithDeals;
	@XmlElement(name="ContactId")
private int contactId;
	@XmlElement(name="IsConnectedToGoogleAccount")
private boolean isConnectedToGoogleAccount;
	@XmlElement(name="GoogleAccountEmail")
private String googleAccountEmail;
	@XmlElement(name="DriveId")
private int driveId;
	@XmlElement(name="ProfilePictureId")
private int profilePictureId;
	@XmlElement(name="AttachmentId")
private int attachmentId;
	@XmlElement(name="ReminderEmailId")
private int reminderEmailId;
	@XmlElement(name="ReminderTypeId")
private String reminderTypeId;
	@XmlElement(name="ReminderTimeId")
private String reminderTimeId;
	@XmlElement(name="UserInterfaceId")
private int userInterfaceId;
	@XmlElement(name="IsDeal")
private boolean isDeal;
	@XmlElement(name="IsPerson")
private boolean isPerson;
	@XmlElement(name="IsOrganization")
private boolean isOrganization;
	@XmlElement(name="TimeZone")
private String timeZone;
	@XmlElement(name="UserLocaleId")
private int userLocaleId;
	@XmlElement(name="LanguageId")
private int languageId;
	@XmlElement(name="CurrencyId")
private int currencyId;
	@XmlElement(name="IsActive")
private boolean isActive;
	@XmlElement(name="CreatedDate")
private String createdDate;
	@XmlElement(name="ModifiedDate")
private String modifiedDate;
	@XmlElement(name="HasPic")
private boolean hasPic;
	@XmlElement(name="RegistrationId")
private int registrationId;
	@XmlElement(name="EmailAddress")
private String emailAddress; 
	@XmlElement(name="UserName")
private String userName;
	@XmlElement(name="IndustryTypeId")
private int industryTypeId;
	@XmlElement(name="LastLogin")
private String lastLogin;
	@XmlElement(name="Token")
private String token;
	public LoginModel(){
		
	}
	
	
	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}


	public int getIndustryTypeId() {
		return industryTypeId;
	}


	public void setIndustryTypeId(int industryTypeId) {
		this.industryTypeId = industryTypeId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public int getRegistrationId() {
		return registrationId;
	}


	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
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


	public boolean isHasPic() {
		return hasPic;
	}


	public void setHasPic(boolean hasPic) {
		this.hasPic = hasPic;
	}


	public boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}


	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getUserLocaleId() {
		return userLocaleId;
	}

	public void setUserLocaleId(int userLocaleId) {
		this.userLocaleId = userLocaleId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}
	public boolean getIsConnectedToMailChimpAccount() {
		return isConnectedToMailChimpAccount;
	}
	public void setIsConnectedToMailChimpAccount(boolean isConnectedToMailChimpAccount) {
		this.isConnectedToMailChimpAccount = isConnectedToMailChimpAccount;
	}
	public String getMailChimpAccountEmail() {
		return mailChimpAccountEmail;
	}
	public void setMailChimpAccountEmail(String mailChimpAccountEmail) {
		this.mailChimpAccountEmail = mailChimpAccountEmail;
	}
	public int getEmailIntegrationId() {
		return emailIntegrationId;
	}
	public void setEmailIntegrationId(int emailIntegrationId) {
		this.emailIntegrationId = emailIntegrationId;
	}
	public String getAlternativeEmailAddress() {
		return alternativeEmailAddress;
	}
	public void setAlternativeEmailAddress(String alternativeEmailAddress) {
		this.alternativeEmailAddress = alternativeEmailAddress;
	}
	public boolean getIsMyLinkedEmailsShared() {
		return isMyLinkedEmailsShared;
	}
	public void setIsMyLinkedEmailsShared(boolean isMyLinkedEmailsShared) {
		this.isMyLinkedEmailsShared = isMyLinkedEmailsShared;
	}
	public boolean getIsMyEmailConversationsPrivate() {
		return isMyEmailConversationsPrivate;
	}
	public void setIsMyEmailConversationsPrivate(boolean isMyEmailConversationsPrivate) {
		this.isMyEmailConversationsPrivate = isMyEmailConversationsPrivate;
	}
	public boolean getIsLinkMyEmailManually() {
		return isLinkMyEmailManually;
	}
	public void setIsLinkMyEmailManually(boolean isLinkMyEmailManually) {
		this.isLinkMyEmailManually = isLinkMyEmailManually;
	}
	public boolean getIsEmailLinkWithDeals() {
		return isEmailLinkWithDeals;
	}
	public void setIsEmailLinkWithDeals(boolean isEmailLinkWithDeals) {
		this.isEmailLinkWithDeals = isEmailLinkWithDeals;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public boolean getIsConnectedToGoogleAccount() {
		return isConnectedToGoogleAccount;
	}
	public void setIsConnectedToGoogleAccount(boolean isConnectedToGoogleAccount) {
		this.isConnectedToGoogleAccount = isConnectedToGoogleAccount;
	}
	public String getGoogleAccountEmail() {
		return googleAccountEmail;
	}
	public void setGoogleAccountEmail(String googleAccountEmail) {
		this.googleAccountEmail = googleAccountEmail;
	}
	public int getDriveId() {
		return driveId;
	}
	public void setDriveId(int driveId) {
		this.driveId = driveId;
	}
	public int getProfilePictureId() {
		return profilePictureId;
	}
	public void setProfilePictureId(int profilePictureId) {
		this.profilePictureId = profilePictureId;
	}
	public int getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}
	public int getReminderEmailId() {
		return reminderEmailId;
	}
	public void setReminderEmailId(int reminderEmailId) {
		this.reminderEmailId = reminderEmailId;
	}
	public String getReminderTypeId() {
		return reminderTypeId;
	}
	public void setReminderTypeId(String reminderTypeId) {
		this.reminderTypeId = reminderTypeId;
	}
	public String getReminderTimeId() {
		return reminderTimeId;
	}
	public void setReminderTimeId(String reminderTimeId) {
		this.reminderTimeId = reminderTimeId;
	}
	public int getUserInterfaceId() {
		return userInterfaceId;
	}
	public void setUserInterfaceId(int userInterfaceId) {
		this.userInterfaceId = userInterfaceId;
	}
	public boolean getIsDeal() {
		return isDeal;
	}
	public void setIsDeal(boolean isDeal) {
		this.isDeal = isDeal;
	}
	public boolean getIsPerson() {
		return isPerson;
	}
	public void setIsPerson(boolean isPerson) {
		this.isPerson = isPerson;
	}
	public boolean getIsOrganization() {
		return isOrganization;
	}
	public void setIsOrganization(boolean isOrganization) {
		this.isOrganization = isOrganization;
	}
	
}
