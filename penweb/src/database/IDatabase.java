package database;

import java.util.ArrayList;
import java.util.List;

import dataStructure.*;
import exceptions.NoIdAvailableException;

/**
 * @author Andy Creeth
 */
public interface IDatabase {
	public void store(IEntry e);
	
	public List<IEntry> getAll();
	
	//public List<IExample> getByHeader(IHeader head); // null is wildcard (this might be an issue, we can change later)
	//public List<IExample> getByHeader(String title, List<IPerson> authors); // null is wildcard (this might be an issue, we can change later)
	
	public List<IExample> getByHeader(String title, IUser owner); // null is wildcard (this might be an issue, we can change later)
	
 	public List<IExample> getByKeyword(String key); // This could be a cool function to implement (match by keyword in body or title)
	// More "getBy" functions to come based on metadata choices
	
 	public void delete(IEntry e);
	
	public void close(); // Close the connection
	
	/**
	 * @return A list of all code examples in the database
	 */
	public List<IExample> getAllExample();
	
	/**
	 * Checks to see if a category name has already been used in the database
	 * @param name
	 * @return true if the name given is already taken by another category
	 * false otherwise 
	 */
	public boolean isNameRepeat (String name);
	
	/**
	 * Checks to see if a user in the database already has the given loginName
	 * @param loginName the name to check
	 * @return True if the name is taken, false otherwise.
	 */
	public boolean isLoginNameTaken (String loginName);
	
	/**
	 * Returns a list of all categories in the database
	 * @return A list of all category names as Strings
	 */
	public ArrayList<String> listCategoryNames();
	
	/**
	 * @return A list of all categories in the database
	 */
	List<ICategory> getAllCategory();

	/**
	 * get a unique id from the database
	 *  @return a unique id (Long)
	 */
	Long getNewId();

	/**
	 * search for an entry by its id (examples or categories)
	 * @return IEntry containing that id if there is only one result.
	 * Null if there is no IEntry with that ID.
	 * @throw non-unique exception if there is more than one result
	 */
	IEntry getByID(Long id);
	
	/**
	 * search for an entry by its id (examples or categories)
	 * @return IEntry containing that id if there is only one result.
	 * Null if there is no IEntry with that ID.
	 * @throw non-unique exception if there is more than one result
	 */
	IEntry getCategoryByID(Long id);

	/**
	 * search for an entry by its id (examples or categories)
	 * @return IEntry containing that id if there is only one result.
	 * Null if there is no IEntry with that ID.
	 * @throw non-unique exception if there is more than one result
	 */
	IEntry getExampleByID(Long id);

	/**
	 * get a unique id from the database
	 *  @return a unique id (Long)
	 */
	Long generateEntryId() throws NoIdAvailableException;
	
	/**
	 * Returns the user with the given login name
	 * @param loginName The name to look for
	 * @return The IUser with the loginName if a match is found. Null otherwise.
	 */
	IUser getUserByLoginName(final String loginName);
	
	/**
	 * Returns the user with the associated ID
	 * @param id The id of the user to find
	 * @return An IUser object if a match is found. Null, otherwise. 
	 */
	IUser getUserByID(final String id);
}
