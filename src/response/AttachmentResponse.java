package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.AttachmentModel;

public class AttachmentResponse {
	@XmlElement(name="IsSuccess")
	private boolean isSuccess;
	@XmlElement(name="Message")
	private String message;
	@XmlElement(name="AttachmentList")
	private ArrayList<AttachmentModel>attachmentList=new ArrayList<AttachmentModel>();
	public AttachmentResponse(){
		
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
	public ArrayList<AttachmentModel> getAttachmentList() {
		return attachmentList;
	}
	public void setAttachmentList(ArrayList<AttachmentModel> attachmentList) {
		this.attachmentList = attachmentList;
	}
	

}
