package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.FilesModel;

public class FilesResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
private String message;
	@XmlElement(name="FilesList")
private ArrayList<FilesModel>filesList=new ArrayList<FilesModel>();
public FilesResponse(){
	
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
public ArrayList<FilesModel> getFilesList() {
	return filesList;
}
public void setFilesList(ArrayList<FilesModel> filesList) {
	this.filesList = filesList;
}


}
