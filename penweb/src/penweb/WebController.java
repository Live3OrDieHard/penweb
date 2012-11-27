package penweb;

import database.*;
import dataStructure.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

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
		this.db = new Db4oDatabase("UNUSED PARAMETER");
	}

	/**
	 * the old embedded mode constructor used for testing purpose
	 * 
	 * @param databaseName
	 */
	public WebController(String databaseName) {
		this.db = new Db4oDatabase(databaseName, true);
	}

	/**
	 * Adds a category to the database. A unique ID is assigned within the DB
	 * 
	 * @param name
	 *            of the desired category
	 * @param desc
	 *            Description of the desired category
	 */
	public void addCategory(String name, String desc) {
		ICategory cat = new Category(name, desc);
		db.store(cat);
	}

	/**
	 * @author awiovanna, tpatikorn, iprangishvili, dmulcahy
	 * @param name
	 *            of the category
	 * @param desc
	 *            description of the category
	 * @param owner
	 *            of the category
	 * @param isPublic
	 *            whether or not the category is public Adds a category with the
	 *            given specifications to the database
	 * @return the id of newly added category
	 */
	public Long addCategory(String name, String desc, IUser owner,
			boolean isPublic) {
		ICategory cat = new Category(name, desc);
		cat.assignOwner(owner);
		cat.setPublic(isPublic);
		return db.store(cat);
	}

	/**
	 * @return a list of all categories stored in the database
	 */
	public List<ICategory> getCategories() {
		return db.getAllCategory();
	}

	/**
	 * As with an example, each category has a unique ID.
	 * 
	 * @param id
	 *            . The hopefully unique ID of the category.
	 * @return the desired category if a category exists with the given ID.
	 */
	public ICategory getCategoryById(Long id) {
		List<ICategory> cats = db.getAllCategory();
		for (ICategory c : cats) {
			if (c.getId().equals(id))
				return c;
		}
		return null; // Error statement needs to be added.
	}

	/**
	 * All methods work by using the id of an example, because each example ID
	 * is unique.
	 * 
	 * @param id
	 *            the unique ID of the desired example.
	 * @return the full example an example with the given id exists.
	 */
	public IExample getExampleById(Long id) {
		List<IExample> ex = db.getAllExample();
		for (IExample e : ex) {
			if (e.getId().equals(id))
				return e;
		}
		return null; // Error statement needs to be added.
	}

	/**
	 * This is the all-important function to add a code example to the database.
	 * 
	 * @param title
	 *            of the code example
	 * @param content
	 *            of the code example. The code itself.
	 * @param language
	 *            So that the user can sort examples by language.
	 * @param author
	 *            So that each example is associated with an author
	 * @return the Id of the code example. Each code example has a unique ID to
	 *         help with writing methods in the database and with sorting
	 *         functions.
	 */
	public long addCode(String title, String content, String language,
			String loginName) {
		// XXX TODO Pass in a username or userId instead of an "author" string.
		IExample ex = new BasicExample();
		ex.setTitle(title);
		ex.setCode(content);
		ex.setLanguage(language);
		// XXX Change the arguments to the login name, password, and displayName
		IUser auth = db.getUserByLoginName(loginName);
		ArrayList<IUser> authors = new ArrayList<IUser>();
		authors.add(auth);
		ex.setAuthors(authors);
		db.store(ex);
		return ex.getId();
	}

	/**
	 * @author awiovanna, tpatikorn
	 * @param title
	 *            of the code example
	 * @param content
	 *            of the code example. The example itself
	 * @param language
	 *            that the code is written in
	 * @param loginName
	 *            to allow us to specify a user with the code example
	 * @param isPublic
	 *            whether or not the code example should appear as public or
	 *            private
	 * @return the id of the code example added to the database or error
	 *         code(maybe) if it cannot be added
	 */
	public Long addCode(String title, String content, String language,
			String loginName, boolean isPublic) {
		// XXX TODO Pass in a username or userId instead of an "author" string.
		IExample ex = new BasicExample();
		ex.setTitle(title);
		ex.setCode(content);
		ex.setLanguage(language);
		ex.setPublic(isPublic);
		// XXX Change the arguments to the login name, password, and displayName
		IUser auth = db.getUserByLoginName(loginName);
		ArrayList<IUser> authors = new ArrayList<IUser>();
		authors.add(auth);
		ex.setAuthors(authors);
		ex.assignOwner(auth);
		return db.store(ex);
	}

	/**
	 * 
	 * @param loginName
	 * @param password
	 * @param displayName
	 * @return true if the user was created successfully. Returns false if not
	 *         successful. The only condition that returns false is if the
	 *         loginName is already taken. It is acceptable for the displayname
	 *         to already be taken.
	 */
	public boolean addUser(String loginName, String password, String displayName) {
		if (db.isLoginNameTaken(loginName))
			return false;

		db.store(new User(loginName, password, displayName));
		return true;
	}

	/**
	 * Attempt to login given a loginName and password.
	 * 
	 * @param loginName
	 *            Name a user should use to login. This is unique across users
	 * @param password
	 *            The password to check
	 * @return True if the user exists and the password was correct. False if
	 *         the user doesn't exist or the password was incorrect.
	 */
	public boolean tryLogin(String loginName, String password) {
		IUser user = db.getUserByLoginName(loginName);

		return ((user != null) && (user.checkPassword(password)));
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
	 * 
	 * @return a list of all of the examples in the database
	 */
	public List<IExample> getExamples() {
		return this.db.getAllExample();
	}

	public IUser getUserByLoginName(String loginName) {
		return db.getUserByLoginName(loginName);
	}

	/**
	 * Takes in an entry and adds it to the database.
	 * 
	 * @param e
	 * 
	 * @return newly added entry's id
	 */
	public Long store(IEntry e) {
		return db.store(e);
	}

	/**
	 * Closes the database connection
	 */
	public void close() {
		db.close();
	}

	/**
	 * wrapper of isCategoryTitleTaken()
	 * 
	 * @param name
	 * @return
	 */
	public boolean isCategoryTitleTaken(String name) {
		return db.isCategoryTitleTaken(name);
	}

	/**
	 * @author awiovanna, tpatikorn This method returns a list of all private
	 *         code examples written in the given language by the given user
	 * @param user
	 *            the identified user
	 * @param language
	 *            the identified language
	 * @return List of all code examples written in language by user
	 */
	public List<IExample> getCodeByLanguageAndUser(IUser user, String language) {
		List<IExample> ExamplesByLanguage = db.getByLanguage(language);
		List<IExample> result = new ArrayList<IExample>();
		// We may want to add a loop that adds every public example to the list
		// before we add specific private ones for the user
		for (IExample e : ExamplesByLanguage) {
			if (e.isPublic() || e.getOwnerId().equals(user.getId())) {
				result.add(e);
			}
		}
		return result;
	}

	/**
	 * @author awiovanna, tpatikorn
	 * @return All public examples in the database
	 */
	public List<IExample> getAllPublicExamples() {
		List<IExample> getAllExamples = db.getAllExample();
		List<IExample> result = new ArrayList<IExample>();
		for (IExample e : getAllExamples) {
			if (e.isPublic()) {
				result.add(e);
			}
		}
		return result;
	}

	/**
	 * @author awiovanna, tpatikorn
	 * @param user
	 *            specified user
	 * @return List of all languages that are used in public examples, 
	 * as well as all languages that are used in private code for the given user.
	 */
	public List<String> getLangList(IUser user) {
		List<IExample> examples = db.getAllExample();
		List<String> result = new ArrayList<String>();
		for (IExample e : examples) {
			if ((e.isPublic() || (user != null && e.getOwnerId().equals(user.getId()))) 
					&& !result.contains(e.getLanguage()))
				result.add(e.getLanguage());
		}
		
		return result;
	}

	/**
	 * @author awiovanna, tpatikorn 
	 * delete an example or a category only if user is the owner of entry and 
	 * - (ICategory) entry has no example 
	 * - (IExample) entry is in no category and no other examples depend on it 
	 * If entry is IUser and user is owner of entry, 
	 * it will print "You want to delete a user? Not yet implemented".
	 * //TODO change to removing instead
	 * NOTE: Return 2 if entry is associated with another entries (categories/examples/dependency)
	 * @param entry to be deleted
	 * @param user the user that is trying to delete. We need to check whether 
	 *        he or she is allowed to delete the given entry.
	 * @return 1 if the user is not allowed to delete the given entry. 0 If the
	 *         owner is allowed to delete the entry, in which case it does get
	 *         deleted. 
	 */
	public int delete(IEntry entry, IUser user) {
		 //not owner
		if (!entry.getOwner().equals(user))
			return 1;
		
		//user is owner
		if (entry instanceof ICategory) {
			if(((ICategory) entry).getExampleList().size()!=0)
			{
				ICategory categoryEntry = (ICategory)entry;
				List<IExample> examples = categoryEntry.getExampleList();
				categoryEntry.removeAllExamples();
				for (IExample example : examples) {
					db.store(example);
				}
			}
		}
		else if (entry instanceof IExample) {
			//TODO: remove categories instead
			IExample exampleEntry = (IExample) entry;
			if(exampleEntry.getCategories().size()!=0)
			{
				List<ICategory> categories = exampleEntry.getCategories();
				exampleEntry.removeFromAllCategories();
				for (ICategory category : categories) {
					db.store(category);
				}
			}

			//TODO: Should we remove if the example is a dependency for another?
			//Check story "Delete a code example from a public notebook"
			if(getDependerOf((IExample) entry).size()!=0)
				return 2;
		} 
		else if(entry instanceof IUser) {
			// TODO Allow deletion for users
			System.out.println("You want to delete a user? Not yet implemented");
		}
		else {
			// TODO ?
			System.out.println("something else?");
		}
		db.delete(entry);
		return 0;
	}

	/**
	 * @author tpatikorn
	 * get all examples in db that depend on example (aka dependers)
	 * @param example the example we want to find what depends on it
	 * @return list of all examples depends on example
	 */
	public List<IExample> getDependerOf(IExample example) {
		List<IExample> allExamples = db.getAllExample();
		List<IExample> result = new ArrayList<IExample>();
		for(IExample e : allExamples) {
			if(e.getDependency().contains(example))
				result.add(e);
		}
		return result;
	}
}
