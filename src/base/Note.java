package base;

import java.util.Date;
import java.util.Objects;

public class Note  implements Comparable<Note>{
	private Date date;
	private String title;
	
	public Note(String title) {
		this.title = title;
		date = new Date(System.currentTimeMillis());
	}
	
	public String getTitle() {
		return this.title;
	}

	public boolean equals(Note n) {
		return this.getTitle().equals(n.getTitle());
	}
	
	public Date getDate() {
		return this.date;
	}

	@Override
	public int compareTo(Note o) {
		// TODO Auto-generated method stub
		return date.compareTo(o.getDate());
	}
	
	public String toString() {
		return date.toString() + "\t" + title;
	}
}
