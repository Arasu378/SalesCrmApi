package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class AttachmentModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElement(name="AttachmentId")
	private int attachmentId;
	@XmlElement(name="AttachmentFileName")
	private String attachmentFileName;
	@XmlElement(name="ContentType")
	private String contentType;
	@XmlElement(name="fileSource")
	private String fileSource;
	@XmlElement(name="FileBinary")
	private String fileBinary;
	@XmlElement(name="AttachedOn")
	private String attachedOn;
	@XmlElement(name="PictureUrl")
	private String pictureUrl;
	public AttachmentModel(){
		
	}
	public int getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}
	public String getAttachmentFileName() {
		return attachmentFileName;
	}
	public void setAttachmentFileName(String attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFileSource() {
		return fileSource;
	}
	public void setFileSource(String fileSource) {
		this.fileSource = fileSource;
	}
	public String getFileBinary() {
		return fileBinary;
	}
	public void setFileBinary(String fileBinary) {
		this.fileBinary = fileBinary;
	}
	public String getAttachedOn() {
		return attachedOn;
	}
	public void setAttachedOn(String attachedOn) {
		this.attachedOn = attachedOn;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	

}
