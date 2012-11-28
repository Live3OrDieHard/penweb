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

/**
 * @author tpatikorn
 * This should refer to a person
 * IUser, IAdmin, INonUser
 */
public interface IPerson 
{
	/**
	 * @return The name of the person as a String.
	 */
	String getName();
	
	/**
	 * @return The ID of the person as a Long. Everything in the DB has an ID.
	 */
	Long getId();
	
	/**
	 * @param name The new name for a person. Fails if the person already has a name.
	 */
	void assignName(String name);
}
