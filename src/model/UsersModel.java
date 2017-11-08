package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class UsersModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElement(name="UserId")
	private int userId;
	@XmlElement(name="Name")
	private String name;
	@XmlElement(name="DefaultCurrency")
	private String defaultCurrency;
	@XmlElement(name="Locale")
	private String locale;
	@XmlElement(name="Lang")
	private String lang;
	@XmlElement(name="Email")
	private String email;
	@XmlElement(name="Phone")
	private String phone;
	@XmlElement(name="Activated")
	private boolean activated;
	@XmlElement(name="LastLogin")
	private String lastLogin;
	@XmlElement(name="Created")
	private String created;
	@XmlElement(name="Modified")
	private String modified;
	@XmlElement(name="SignupFlowVariation")
	private String signupFlowVariation;
	@XmlElement(name="HasCreatedCompany")
	private String hasCreatedCompany;
	@XmlElement(name="IsAdmin")
	private String isAdmin;
	@XmlElement(name="TimeZoneName")
	private String timeZoneName;
	@XmlElement(name="TimeZoneOffset")
	private String timeZoneOffset;
	@XmlElement(name="ActiveFlag")
	private boolean activeFlag;
	@XmlElement(name="RoleId")
	private int roleId;
	@XmlElement(name="IconUrl")
	private String iconUrl;
	@XmlElement(name="IsYou")
	private boolean isYou;
	@XmlElement(name="UserProfileId")
	private int userProfileId;
	public UsersModel(){
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDefaultCurrency() {
		return defaultCurrency;
	}
	public void setDefaultCurrency(String defaultCurrency) {
		this.defaultCurrency = defaultCurrency;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean getActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getSignupFlowVariation() {
		return signupFlowVariation;
	}
	public void setSignupFlowVariation(String signupFlowVariation) {
		this.signupFlowVariation = signupFlowVariation;
	}
	public String getHasCreatedCompany() {
		return hasCreatedCompany;
	}
	public void setHasCreatedCompany(String hasCreatedCompany) {
		this.hasCreatedCompany = hasCreatedCompany;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getTimeZoneName() {
		return timeZoneName;
	}
	public void setTimeZoneName(String timeZoneName) {
		this.timeZoneName = timeZoneName;
	}
	public String getTimeZoneOffset() {
		return timeZoneOffset;
	}
	public void setTimeZoneOffset(String timeZoneOffset) {
		this.timeZoneOffset = timeZoneOffset;
	}
	public boolean getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public boolean getIsYou() {
		return isYou;
	}
	public void setIsYou(boolean isYou) {
		this.isYou = isYou;
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	

}
