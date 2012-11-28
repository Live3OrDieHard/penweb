/*******************************************************************************
 * Copyright (c) 2012 Team 3: Live Three or Die Hard
 * 
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Team 3
 *******************************************************************************/

package database;

import java.util.ArrayList;
import java.util.List;

import dataStructure.*;
import exceptions.NoIdAvailableException;

/**
 * @author Andy Creeth
 * @author Justin Chines
 * @author March
 * 
 * Database interface for storing and retrieving objects. This 
 * contains many methods to retrieve objects from the database using 
 * headers, ids, names, or more. More methods may be added laters.
 */
public interface IDatabase {
	/**
	 * Stores the given entry in the database. If the object is already in the database, it will be updated.
	 * @param e The entry to store.
	 * @return the id of the newly added entry
	 */
	public Long store(IEntry e);
	
	/**
	 * @return All entries in the database
	 */
	public List<IEntry> getAll();
	
	//public List<IExample> getByHeader(IHeader head); // null is wildcard (this might be an issue, we can change later)
	//public List<IExample> getByHeader(String title, List<IUser> authors); // null is wildcard (this might be an issue, we can change later)
	
	/**
	 * Searches through the database for examples with headers containing
	 * information matching the given information. Null for either argument 
	 * denotes a wild-card.
	 * 
	 * @param title The title of an example to look for.
	 * @param owner The owner of an example to look for.
	 * @return A list of examples matching the given information.
	 */
	public List<IExample> getByHeader(String title, IUser owner);
	
	/**
	 * CURRENTLY UNIMPLEMENTED. Searches through database for keyword in
	 * descriptions or titles
	 * 
	 * @param key The keyword to search for. 
	 * @return List of matched examples
	 */
 	public List<IExample> getByKeyword(String key);
	
 	/**
 	 * Deletes the given entry from the database
 	 * @param e The object to delete
 	 */
 	public void delete(IEntry e);
	
 	/**
 	 * Closes the database connection
 	 */
	public void close();
	
	/**
	 * @return A list of all code examples in the database
	 */
	public List<IExample> getAllExample();
	
	
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
	IUser getUserByID(Long id);
	
	/**
	 * check if category title is taken
	 */
	boolean isCategoryTitleTaken(String name);
	
	List<IExample> getByLanguage(String lang);
	
	List<IExample> getExampleByUser(IUser user);
}
