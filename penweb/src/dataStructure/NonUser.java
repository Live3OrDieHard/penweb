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
 * for non-user people involved 
 * e.g. authors that are not users
 */
public class NonUser implements IPerson {
	/**
	 * The name of the NonUser
	 */
	private String name;

	/**
	 * Default constructor for the NonUser class
	 */
	public NonUser(String name) {
		this.name = name;
	}

	/**
	 * @see dataStructure.IPerson#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * @see dataStructure.IPerson#assignName(String)
	 */
	@Override
	public void assignName(String name) {
		if (this.name != null) {
			// throw exception
		} else
			this.name = name;
	}

	@Override
	public Long getId() {
		return null;
	}

}
