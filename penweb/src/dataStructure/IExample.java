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
 * IExample is basically the actual entry (code/test/etc)
 * Prof. Pollice prefers to call it an example.
 */
public interface IExample extends IEntry
{
	/**
	 * Adds the example to the given category
	 * @param category The category the code example should be added to
	 * @throws DuplicateException 
	 */
	void addCategory(ICategory category) throws DuplicateException;
	
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
	 * @return The description of an example
	 */
	String getDescription();

	String getLanguage();

	/**
	 * @return The person who 'owns' this example
	 */
	IUser getOwner();
	
	String getSource();
	
	/**
	 * @return The title of an example
	 */
	String getTitle();
	
	/**
	 * @param a ArrayList<IPerson>: A list of authors
	 */
	void setAuthors(ArrayList<IUser> a);
	
	void setCategories(ArrayList<ICategory> categories);
	
	List<Long> getCategoryIds();
	
	/**
	 * @param code The code content to be associated with an example
	 */
	void setCode(String code);

	/**
	 * @param d String: A new description
	 */
	void setDescription(String d);

	void setLanguage(String language);

	void setSource(String source);

	/**
	 * @param t String: a new title
	 */
	void setTitle(String t);

	void setTags(ArrayList<String> tags);

	ArrayList<String> getTags();

	String getAuthorsNames();
	
	String getComment();
	
	void setComment(String comment);
	
	void addDependency(IExample example);
	
	ArrayList<IExample> getDependency();

	void removeFromAllCategories();

	void removeFromCategory(ICategory category);
	
	boolean isPublic();
	
	void setPublic(boolean changePublic); 
}
