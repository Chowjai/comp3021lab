package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.*;

public class Folder implements Comparable<Folder> {
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

		for (Note n : notes) {
			if (n instanceof TextNote) {
				nText += 1;
			} else
				nImage += 1;
		}
		return name + ":" + nText + ":" + nImage;
	}

	@Override
	public int compareTo(Folder o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}

	public void sortNotes() {
		// TO DO
		Collections.sort(notes);
	}

	public List<Note> searchNotes(String keywords) {

		// TO DO
		List<Note> matchList = new ArrayList<>(); // store matching notes, which will be returned
		// e.g. "java or LAB attendance OR SESSION", want become {"java or LAB",
		// "attendance OR SESSION"}
		String keyword[] = keywords.split("(?<!\\bor)(?<!\\bOR) (?!\\bor)(?!\\bOR)");
		for (Note n : notes) {
			boolean isMatched1 = true; // default true, set to false if any word missing
			for (String s1 : keyword) {
				// for each of the keyword, split the condition by "or" && "OR"
				s1 = s1.trim();
				//System.out.println("s1: " + s1);
				String s2[] = s1.split("\\bor|\\bOR");

				// boolean isMatched2 = false; // flag for whether to put in matchList, matching
				// one is enough(or)
				boolean isMatched2 = false; // default false, matching either will be true
				for (String s3 : s2) {
					s3 = s3.trim();
					//System.out.println("s3 :" + s3);
					if (n instanceof TextNote) {
						// check both title and content
						if (n.getTitle().toLowerCase().contains(s3.toLowerCase()) || ((TextNote) n).getContext().toLowerCase().contains(s3.toLowerCase())) {
							// condition is matched
							isMatched2 = true;
							//System.out.println("inner loop suceed");
						}
					} else {
						// check title
						if (n.getTitle().toLowerCase().contains(s3.toLowerCase())) {
							// condition is matched
							isMatched2 = true;
							//System.out.println("inner loop suceed");
						}
					}
				}
				if (isMatched2 == false) {
					isMatched1 = false; // if the inner condition fails, the outer also fails
					//System.out.println("inner loop fails");
					break;
				}
			}
			if (isMatched1 == true) {
				//System.out.println("outer loop suceed");
				matchList.add(n); // all conditions met, thus add the note
			} else {
				//System.out.println("inner loop failed");
			}
		}
		return matchList;
	}
}