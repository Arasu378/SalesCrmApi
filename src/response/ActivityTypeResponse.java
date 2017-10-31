package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.ActivityTypeModel;

public class ActivityTypeResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
private String message;
	@XmlElement(name="ActivityTypeList")
private ArrayList<ActivityTypeModel>activityTypeList=new ArrayList<ActivityTypeModel>();
public ActivityTypeResponse(){
	
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
public ArrayList<ActivityTypeModel> getActivityTypeList() {
	return activityTypeList;
}
public void setActivityTypeList(ArrayList<ActivityTypeModel> activityTypeList) {
	this.activityTypeList = activityTypeList;
}

}
