package penweb;

import database.*;
import dataStructure.*;

import java.util.List;
import java.util.ArrayList;

public class WebController {

	private IDatabase db;
	
	public WebController() {
		this.db = new Db4oDatabase("webDb2.yap");
	}
	
	public void populate() {
		// Add some stuff to the database
		addCategory("Test Cat", "This is a test cat");
		addCategory("Another Cat", "This is another cat");
	}
	
	public void addCategory(String name, String desc) {
		ICategory cat = new Category(name, desc);
		db.store(cat);
	}
	
	public List<ICategory> getCategories() {
		return db.getAllCategory();
	}
	
	public ICategory getCategoryById(Long id) {
		List<ICategory> cats = db.getAllCategory();
		for (ICategory c : cats) {
			if (c.getId().equals(id))
				return c;
		}
		return null;
	}
	
	public IExample getExampleById(Long id) {
		List<IExample> ex = db.getAllExample();
		for (IExample e : ex) {
			if (e.getId().equals(id))
				return e;
		}
		return null;
	}
	
	public void addCode(String title, String content, String language, String author) {
		IExample ex = new BasicExample();
		ex.setTitle(title);
		ex.setCode(content);
		ex.setLanguage(language);
		IPerson auth = new User();
		auth.assignName(author);
		List<IPerson> authors = new ArrayList<IPerson>();
		authors.add(auth);
		ex.setAuthors(authors);
		db.store(ex);
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
	
	public List<IExample> getExamples() {
		return this.db.getAllExample();
	}
	
	public void close() {
		db.close();
	}
}
