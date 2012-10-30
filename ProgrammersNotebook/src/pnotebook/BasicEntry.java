package pnotebook;

public class BasicEntry implements Entry {

	private String title;
	private String body;
	
	public BasicEntry(String title, String body) {
		this.title = title;
		this.body = body;
	}
	
	public String getBody() {
		return this.body;
	}
	
	public String getTitle() {
		return this.title;
	}

}
