package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.ActivityModel;

public class ActivityResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
private String message;
	@XmlElement(name="ActivityList")
private ArrayList<ActivityModel>activityList=new ArrayList<ActivityModel>();
public ActivityResponse(){
	
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
public ArrayList<ActivityModel> getActivityList() {
	return activityList;
}
public void setActivityList(ArrayList<ActivityModel> activityList) {
	this.activityList = activityList;
}

}
