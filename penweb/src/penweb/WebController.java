package penweb;

import database.*;
import dataStructure.*;

import java.util.List;
import java.util.ArrayList;

/**
 * Controller for the web interface
 * 
 * @author jfchines
 * @author awiovanna
 * @author Neil Pomerleau
 * @author Andy C
 * @author Chrissy
 * @author Mikey 
 */
public class WebController {

	private IDatabase db;
	
	public WebController() {
		this.db = new Db4oDatabase("webDb4.yap");
	}
	
	/**
	 * loltest
	 */
	public void populate() {
		// Add some stuff to the database
		addCategory("Test Cat", "This is a test cat");
		addCategory("Another Cat", "This is another cat");
	}
	
	/**
	 * Adds a category to the database. A unique ID is assigned within the DB
	 * @param name of the desired category
	 * @param desc Description of the desired category
	 */
	public void addCategory(String name, String desc) {
		ICategory cat = new Category(name, desc);
		db.store(cat);
	}
	
	/**
	 * @return a list of all categories stored in the database 
	 */
	public List<ICategory> getCategories() {
		return db.getAllCategory();
	}

	/**
	 * As with an example, each category has a unique ID. 
	 * @param id. The hopefully unique ID of the category.
	 * @return the desired category if a category exists with the given ID. 
	 */
	public ICategory getCategoryById(Long id) {
		List<ICategory> cats = db.getAllCategory();
		for (ICategory c : cats) {
			if (c.getId().equals(id))
				return c;
		}
		return null;  //Error statement needs to be added. 
	}
	
	/**
	 * All methods work by using the id of an example, because each example ID is unique.
	 * @param id the unique ID of the desired example. 
	 * @return the full example an example with the given id exists. 
	 */
	public IExample getExampleById(Long id) {
		List<IExample> ex = db.getAllExample();
		for (IExample e : ex) {
			if (e.getId().equals(id))
				return e;
		}
		return null; //Error statement needs to be added. 
	}
	
	/** 
	 * This is the all-important function to add a code example to the database. 
	 * @param title of the code example
	 * @param content of the code example. The code itself. 
	 * @param language So that the user can sort examples by language.
	 * @param author So that each example is associated with an author
	 * @return the Id of the code example.
	 * Each code example has a unique ID to help with writing methods in the database and 
	 * with sorting functions. 
	 */
	public long addCode(String title, String content, String language, String author) {
		//XXX TODO Pass in a username or userId instead of an "author" string.
		IExample ex = new BasicExample();
		ex.setTitle(title);
		ex.setCode(content);
		ex.setLanguage(language);
		//XXX Change the arguments to the login name, password, and displayName
		IUser auth = new User(null, null, null);
		ArrayList<IUser> authors = new ArrayList<IUser>();
		authors.add(auth);
		ex.setAuthors(authors);
		db.store(ex);
		return ex.getId();
	}
	
	/**
	 * 
	 * @param loginName
	 * @param password
	 * @param displayName
	 * @return true if the user was created successfully. Returns false if not successful.
	 * The only condition that returns false is if the loginName is already taken. It is acceptable for the 
	 * displayname to already be taken.
	 */
	public boolean addUser(String loginName, String password, String displayName) {
		if (db.isLoginNameTaken(loginName))
			return false;
		
		db.store(new User(loginName, password, displayName));
		return true;
	}
	
	/**
	 * Attempt to login given a loginName and password.
	 * @param loginName Name a user should use to login. This is unique across users
	 * @param password The password to check
	 * @return True if the user exists and the password was correct. False if 
	 * the user doesn't exist or the password was incorrect.
	 */
	public boolean tryLogin(String loginName, String password) {
		IUser user = db.getUserByLoginName(loginName);
		
		return ((user != null) && (user.checkPassword(password)));
	}
	
	
	public String getText() {
		return "Testing text";
	}
	
	/**
	 * 
	 * @return a list of all of the code examples currently in existence
	 */
	public List<String> getTitles() {
		List<IExample> examples = this.db.getAllExample();
		List<String> titles = new ArrayList<String>();
		for (IExample e : examples) {
			titles.add(e.getTitle());
		}
		return titles;
	}
	
	/**
	 * @return the number of entries in the database.
	 */
	public int getNumEntries() {
		List<IExample> examples = this.db.getAllExample();
		return examples.size();
	}
	
	/**
	 * Getter function to get all of the examples
	 * @return a list of all of the examples in the database
	 */
	public List<IExample> getExamples() {
		return this.db.getAllExample();
	}
	
	/**
	 * Takes in an entry and adds it to the database. 
	 * @param e
	 */
	public void store(IEntry e) {
		db.store(e);
	}
	
	/**
	 * Closes the database connection
	 */
	public void close() {
		db.close();
	}
}
