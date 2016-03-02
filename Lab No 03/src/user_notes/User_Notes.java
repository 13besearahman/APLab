package user_notes;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class User_Notes implements Serializable {

	private String Username;
	private ArrayList<String> notes;
		
	public User_Notes(String un){
		Username = un;
		notes = new ArrayList<String>();
	}
	
	public String getUsername(){
		return Username;
	}
	
	public void setUsername(String un) {
		Username = un;
	}
	public ArrayList<String> getNotes() {
		return notes;
	}
	public void setNotes(ArrayList<String> notes) {
		this.notes = notes;
	}
	
}
