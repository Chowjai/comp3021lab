package base;

import java.util.ArrayList;

public class Folder {
	private ArrayList<Note> notes;
	private String name;
	
	public Folder(String name) {
		this.name = name;
		this.notes = new ArrayList<>();
	}
	
	public void addNote(Note newNote) {
		this.notes.add(newNote);
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Note> getNotes() {
		return this.notes;
	}
	
	public String toString() {
		int nText = 0;
		int nImage = 0;
		
		for (Note n: notes) {
			 if (n instanceof TextNote) {
				 nText += 1;
			 }
			 else
				 nImage += 1; 
		}
		return name + ":" + nText + ":" + nImage;
	}
}
