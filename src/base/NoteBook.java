package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoteBook {
	private ArrayList<Folder> folders;

	public NoteBook() {
		folders = new ArrayList<>();
	}

	public boolean createTextNote(String folderName, String title) {
		TextNote note = new TextNote(title);
		return insertNote(folderName, note);
	}
	
	public boolean createTextNote(String folderName, String title, String content) {
		TextNote note = new TextNote(title, content);
		return insertNote(folderName, note);
	}

	public boolean createImageNote(String folderName, String title) {
		ImageNote note = new ImageNote(title);
		return insertNote(folderName, note);
	}

	public ArrayList<Folder> getFolders() {
		return folders;
	}

	public boolean insertNote(String folderName, Note note) {
		Folder f = null; // pointer to point at found object
		for (Folder f1 : folders) {
			if (f1.getName() == folderName) {
				f = f1; // assign if found
				break;
			}
		}
		if (f == null) { // new if not found
			f = new Folder(folderName);
			folders.add(f);
		}

		for (Note n1 : f.getNotes()) {
			if (n1.equals(note)) {
				System.out.println("Creating note " + note.getTitle() + " under folder " + folderName + " failed");
				return false;
			}
		}

		f.addNote(note); // it does not exist, then add note to folder
		return true;
	}

	public void sortFolders() {
		// TO DO
		for (Folder f : folders) {
			f.sortNotes();
		}
		Collections.sort(folders);
	}

	public List<Note> searchNotes(String keywords) {
		// TO DO
		List<Note> notes = new ArrayList<>();
		for (Folder f : folders) {
			List<Note> results = f.searchNotes(keywords);

			if (results != null) {
				notes.addAll(results);
			}
		}
		return notes;
	}
}
