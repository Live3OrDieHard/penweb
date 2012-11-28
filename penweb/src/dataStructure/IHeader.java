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

import java.util.List;

/**
 * @author tpatikorn
 * An instance of IHeader should contains data that identify the IEntry
 * (like name and author/owner)
 * IHeader should give IEntry uniqueness.
 * ***No longer used***
 */
public interface IHeader 
{
	/**
	 * The getter function to get the title of the example
	 * @return String
	 */
	String getTitle();
	
	/**
	 * Set the title of the example to the given string
	 * @param String title
	 */
	void setTitle(String t);
	
	/**
	 * The getter function to get the authors of the examples
	 * @return List<IPerson>
	 */
	List<IUser> getAuthors();
	
	/**
	 * Set the authors of the example to the given authors
	 * @param List<IPerson> The authors for the example
	 */
	void setAuthors(List<IUser> a);
}
