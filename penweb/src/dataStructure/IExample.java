/*******************************************************************************
 * Copyright (c) 2012 Team 3: Live Three or Die Hard
 * 
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Team 3
 *******************************************************************************/

package dataStructure;

import java.util.ArrayList;
import java.util.List;

import exceptions.DuplicateException;

/**
 * @author tpatikorn
 * IExample is the code entry that a user is allowed to create on the website.
 */
public interface IExample extends IEntry
{
	/**
	 * Adds the example to the given category
	 * @param category The category the code example should be added to
	 * @throws DuplicateException 
	 */
	void addCategory(ICategory category) throws DuplicateException;

	/**
	 * add the given tag to the example
	 * 
	 * @param tag
	 */
	void addTags(String tag);

	/**
	 * getAuthors is a list of authors found from the users created.
	 * @return List of authors
	 */
	List<IUser> getAuthors();

	/**
	 * @return The list of categories that an example belongs to
	 */
	List<ICategory> getCategories();

	/**
	 * @return The code in the example as a String
	 */
	String getCode();

	/**
	 * Gets the language the example was written in
	 * @return String
	 */
	String getLanguage();

	/**
	 * @return The person who 'owns' this example
	 */
	IUser getOwner();

	/**
	 * A setter fucntion to set the source property of the example
	 * to the given source
	 * 
	 * @param source
	 */
	String getSource();

	/**
	 * @return The title of an example
	 */
	String getTitle();

	/**
	 * @param a ArrayList<IPerson>: A list of authors
	 */
	void setAuthors(ArrayList<IUser> a);
	/**
	 * A setter function to set the tag property of the example 
	 * to the given categories.
	 * 
	 * @param tags
	 */
	void setCategories(ArrayList<ICategory> categories);
	/**
	 * @return a list of ids of category in the categorylist
	 */
	List<Long> getCategoryIds();

	/**
	 * @param code The code content to be associated with an example
	 */
	void setCode(String code);
	/**
	 * A setter function to set the language property of the example
	 * to the given language
	 * 
	 * @param language
	 */
	void setLanguage(String language);

	void setSource(String source);

	/**
	 * @param t String: a new title
	 */
	void setTitle(String t);
	
	/**
	 * a setter function to set the tag property of the example to the given
	 * tags
	 * 
	 * @param tags
	 */
	void setTags(ArrayList<String> tags);
	/**
	 * a getter function to get the tags of the example
	 * 
	 * @return LinkedList<String>
	 */
	ArrayList<String> getTags();
	/**
	 * Perhaps this should be moved into the controller. 
	 * I don't know how I feel about functions with a lot of logic
	 * like this in the dataStructure classes
	 */
	String getAuthorsNames();
	/**
	 * The getter function to get comment of the example
	 * @return
	 * 		  the comment of the example
	 */
	String getComment();
	/**
	 * The setter function to set the comment for the example
	 */
	void setComment(String comment);
	/**
	 * Add dependencies to the given examples
	 * @param examples
	 */
	void addDependency(IExample example);
	/**
	 * Add dependencies to the given examples
	 * @return dependency
	 */
	ArrayList<IExample> getDependency();
	/**
	 * The method is used to remove all the categories from
	 * the category list.
	 */
	void removeFromAllCategories();
	/**
	 * The method is used to remove the given category from the
	 * current categorylist
	 * 
	 * @param category. The category that will be removed from
	 * the current category list. 
	 */
	void removeFromCategory(ICategory category);
	/**
	 * Getter method that returns whether or not a given code example is public or not
	 * @return true if the code example is public. False otherwise. 
	 */
	boolean isPublic();
	/**
	 * Sets the isPublic field to the given boolean.
	 */
	void setPublic(boolean changePublic);
	/**
	 * remove the given example from the dependency list
	 * @param 
	 *       an example supposed to be removed from the dependency list
	 */
	void removeDependeny(IExample example); 

}
