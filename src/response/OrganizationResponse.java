package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.OrganizationModel;

public class OrganizationResponse {
	@XmlElement(name="IsSuccess")
	private boolean isSuccess;
	@XmlElement(name="Message")
	private String message;
	@XmlElement(name="OrganizationList")
	private ArrayList<OrganizationModel>organizationList=new ArrayList<OrganizationModel>();
	public OrganizationResponse(){
		
	}
	public boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<OrganizationModel> getOrganizationList() {
		return organizationList;
	}
	public void setOrganizationList(ArrayList<OrganizationModel> organizationList) {
		this.organizationList = organizationList;
	}
	

}
