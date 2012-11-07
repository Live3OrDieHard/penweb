package penweb;

import database.*;
import dataStructure.*;
import java.util.List;
import java.util.ArrayList;

public class WebController {

	private IDatabase db;
	
	public WebController() {
		this.db = new Db4oDatabase("webDb.yap");
	}
	
	public void populate() {
		// Add some stuff to the database
		IExample e1 = new BasicExample();
		e1.setTitle("test1");
		IExample e2 = new BasicExample();
		e2.setTitle("test2");
		db.store(e1);
		db.store(e2);
	}
	
	public void addCode(String title, String content, String language, String author) {
		IExample ex = new BasicExample();
	}
	
	public String getText() {
		return "Testing text";
	}
	
	public List<String> getTitles() {
		List<IExample> examples = this.db.getAllExample();
		List<String> titles = new ArrayList<String>();
		for (IExample e : examples) {
			titles.add(e.getTitle());
		}
		return titles;
	}
	
	public int getNumEntries() {
		List<IExample> examples = this.db.getAllExample();
		return examples.size();
	}
	
	public void close() {
		db.close();
	}
}
