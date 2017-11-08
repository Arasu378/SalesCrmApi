package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.NotesModel;

public class NotesResponse {
	@XmlElement(name="IsSuccess")
private boolean isSuccess;
	@XmlElement(name="Message")
private String message;
	@XmlElement(name="NotesList")
private ArrayList<NotesModel>notesList=new ArrayList<NotesModel>();
	@XmlElement(name="Id")
private int id;
public NotesResponse(){
	
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
public ArrayList<NotesModel> getNotesList() {
	return notesList;
}
public void setNotesList(ArrayList<NotesModel> notesList) {
	this.notesList = notesList;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
