package database;

import java.util.ArrayList;
import java.util.List;
import com.db4o.*;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.*;

import dataStructure.ICategory;
import dataStructure.IEntry;
import dataStructure.IExample;
import dataStructure.IUser;
import dataStructure.IPerson;
import exceptions.NoIdAvailableException;

/*
 * How to create a new instance of this database using IDatabase:
 * IDatabase db = new Db4oDatabase("db/localDb.yap");
 * 
 * Now you can store and query
 * db.store(anEntry);
 * List<IEntry> entries = db.getAll();
 * 
 * If you have any questions about how to use this ask Andy C <andy@wpi.edu>
 */

/**
 * @author Andy Creeth
 */
public class Db4oDatabase implements IDatabase {
	final private long maxID = 100000000000L;
	private ObjectContainer db;

	public Db4oDatabase(String path) {
		EmbeddedConfiguration configuration = Db4oEmbedded.newConfiguration();
		configuration.common().updateDepth(10);
		configuration.common().activationDepth(10);
		
		db = Db4oEmbedded.openFile(configuration, path);
	}

	@Override
	public void store(IEntry e) {
		e.assignOwner(null);
		e.assignId(this.getNewId());
		db.store(e);
	}
	
	/**
	 * NO. Shouldn't be used. NO.
	 */
	@Override
	public List<IEntry> getAll() {
		return db.query(IEntry.class);
	}

	@Override
	public List<IExample> getByHeader(final String title, final IUser owner) {

		boolean hasTitle = (title != null);
		boolean hasOwner = (owner != null);

		// All authors searches only work if lists are ordered the same.
		if (hasTitle && hasOwner) {
			return db.query(new Predicate<IExample>() {
				public boolean match(IExample e) {
					return (e.getTitle().equals(title) && e.getOwnerId() == owner
							.getId());
				}
			});
		} else if (hasTitle) {
			return db.query(new Predicate<IExample>() {
				public boolean match(IExample e) {
					return e.getTitle().equals(title);
				}
			});
		} else if (hasOwner) {
			return db.query(new Predicate<IExample>() {
				public boolean match(IExample e) {
					if (e.getOwner() != null)
						return e.getOwner().getLoginName().equals(owner.getLoginName());
					else
						return (e.getOwner() == owner);
				}
			});
		} else
			return db.query(IExample.class);
	}

	@Override
	public List<IExample> getByKeyword(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(IEntry e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void close() {
		db.close();
	}

	/**
	 * @return A list of all examples in the database
	 */
	public List<IExample> getAllExample() {
		return db.query(IExample.class);
	}

	/**
	 * @return A list of all categories in the database
	 */
	public List<ICategory> getAllCategory() {
		return db.query(ICategory.class);
	}

	/**
	 * @return A list of all users in the database
	 */
	public List<IUser> getAllUsers() {
		return db.query(IUser.class);
	}

	/**
	 * @return A list of all category names.
	 */
	public ArrayList<String> listCategoryNames() {
		List<ICategory> catList = getAllCategory();
		ArrayList<String> nameList = new ArrayList<String>();
		for (int i = 0; i < catList.size(); i++) {
			nameList.add(catList.get(i).getTitle());
		}
		return nameList;
	}
	
	/**
	 * @return A list of strings containing all user login names in the database
	 */
	public ArrayList<String> listUserLoginNames() {
		List<IUser> userList = getAllUsers();
		ArrayList<String> loginNameList = new ArrayList<String>();
		
		for (IUser user : userList) {
			loginNameList.add(user.getLoginName());
		}
		
		return loginNameList;
	}

	/**
	 * @param name
	 * @return true if the name given is already taken by another category false
	 *         otherwise
	 */
	public boolean isNameRepeat(String name) {
		return listCategoryNames().contains(name);
	}
	
	/**
	 * @param loginName
	 * @return True if a user has already been created with the given login name, false otherwise
	 */
	public boolean isLoginNameTaken(String loginName) {
		return listUserLoginNames().contains(loginName);
	}

	@Override
	/**
	 * search for an entry by its id (examples or categories)
	 * @return IEntry containing that id if there is only one result.
	 * Null if there is no IEntry with that ID.
	 * @throw non-unique exception if there is more than one result
	 */
	public IEntry getByID(final Long id) {
		List<IEntry> list = db.query(new Predicate<IEntry>() {
			public boolean match(IEntry e) {
				Long thisid = e.getId();
				return (thisid.equals(id));
			}
		});
		if (list.size() == 1)
			return list.get(0);
		else if (list.size() == 0)
			return null;
		else
			return null; // throw non-unique exception if there is more than one
							// result
	}

	@Override
	/**
	 * get a unique id from the database
	 *  @return a unique id (Long)
	 */
	public Long getNewId() {
		return (long) (Math.random()*100000000); // should have a better way to do
		// this
	}
	
	@Override
	/**
	 * search for an entry by its id (examples or categories)
	 * @return IEntry containing that id if there is only one result.
	 * Null if there is no IEntry with that ID.
	 * @throw non-unique exception if there is more than one result
	 */
	public ICategory getCategoryByID(final Long id) {
		List<ICategory> list = db.query(new Predicate<ICategory>() {
			public boolean match(ICategory e) {
				Long thisid = e.getId();
				return (thisid.equals(id));
			}
		});
		if (list.size() == 1)
			return list.get(0);
		else if (list.size() == 0)
			return null;
		else
			return null; // throw non-unique exception if there is more than one
							// result
	}

	@Override
	/**
	 * search for an entry by its id (examples or categories)
	 * @return IEntry containing that id if there is only one result.
	 * Null if there is no IEntry with that ID.
	 * @throw non-unique exception if there is more than one result
	 */
	public IExample getExampleByID(final Long id) {
		List<IExample> list = db.query(new Predicate<IExample>() {
			public boolean match(IExample e) {
				Long thisid = e.getId();
				return (thisid.equals(id));
			}
		});
		if (list.size() == 1)
			return list.get(0);
		else if (list.size() == 0)
			return null;
		else
			return null; // throw non-unique exception if there is more than one
							// result
	}

	@Override
	/**
	 * get a unique id from the database
	 *  @return a unique id (Long)
	 */
	public Long generateEntryId() throws NoIdAvailableException {
		//try to generate random number first
		for(long i=0;i<maxID;i++) {
			long newId = (long) (Math.random()*maxID);
			if(this.getByID(newId)==null)
				return newId;
		}
		//if no ID available after randomizing maxID times, loop through to check
		for(long newId=0;newId<maxID;newId++) {
			if(this.getByID(newId)==null)
				return newId;
		}
		throw(new NoIdAvailableException(maxID,"MaxID reached"));
	}

}
