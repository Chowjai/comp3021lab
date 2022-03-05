package base;

public class TextNote extends Note {
	private String context;
	
	public TextNote(String title) {
		super(title);
	}
	
	public TextNote(String title, String content) {
		//TO DO
		super(title);
		this.context = content;
	}
	public String getContext() {
		return this.context;
	}
}
