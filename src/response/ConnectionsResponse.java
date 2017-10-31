package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.ConnectionsModel;

public class ConnectionsResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
private String message;
	@XmlElement(name="ConnectionList")
private ArrayList<ConnectionsModel>connectionList=new ArrayList<ConnectionsModel>();
public ConnectionsResponse(){
	
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
public ArrayList<ConnectionsModel> getConnectionList() {
	return connectionList;
}
public void setConnectionList(ArrayList<ConnectionsModel> connectionList) {
	this.connectionList = connectionList;
}

}
