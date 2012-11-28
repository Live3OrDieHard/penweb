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

/**
 * @author tpatikorn
 * @author jfchines
 * @author awiovanna
 * @author kirkgrimsley
 * @author avenkatesh
 * 
 *         A registered user who owns examples and categories.
 */
public class User implements IUser {
	private final String loginName; // Name used for logging in. This has to be
									// unique.
	private String displayName; // Name displayed to others on the site on
								// examples, categories, etc
	private String password;
	private ArrayList<IExample> ownedExamples;
	private ArrayList<ICategory> ownedCategories;

	/**
	 * A list of examples that the user has edited. This includes any examples
	 * that the user is listed as an "author" for.
	 */
	private ArrayList<IExample> editedExamples;
	private Long id;

	public User(String loginName, String password, String displayName) {
		this.loginName = loginName;
		this.password = password;
		this.displayName = displayName;

		this.ownedExamples = new ArrayList<IExample>();
		this.ownedCategories = new ArrayList<ICategory>();
		this.editedExamples = new ArrayList<IExample>();
		this.id = new Long(-1);
	}

	@Override
	public String getLoginName() {
		return this.loginName;
	}

	@Override
	public String getDisplayName() {
		return this.displayName;
	}

	@Override
	public void changeDisplayName(String name) {
		this.displayName = name;
	}

	@Override
	public void changePassword(String oldPassword, String newPassword,
			String reenterNew) {
		if (oldPassword.equals(this.password) && newPassword.equals(reenterNew)) {
			this.password = newPassword;
		}
		// needs else case to the effect of
		// System.out.println("Passwords do not match! Password not reset.") or
		// ("Correct password not entered! Password not reset.") case when we
		// know how we're handling it on the front end
	}

	public int assignId(Long id) {
		if (this.id != -1)
			return 1; // return 1 if already assigned
		else
			this.id = id;
		return 0;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public Boolean checkPassword(String passwordAttempt) {
		return (passwordAttempt.equals(this.password));
	}

	@Override
	public void addOwnedExample(IExample example) {
		ownedExamples.add(example);
	}

	@Override
	public List<IExample> getOwnedExampleList() {
		return ownedExamples;
	}

	@Override
	public void addOwnedCategory(ICategory category) {
		ownedCategories.add(category);
	}

	@Override
	public List<ICategory> getOwnedCategoryList() {
		return ownedCategories;
	}

	@Override
	public void addEditedExample(IExample example) {
		editedExamples.add(example);
	}

	@Override
	public List<IExample> getEditedExampleList() {
		return editedExamples;
	}

	// XXX TODO For now these will do nothing
	// //////////////////////////////////////
	@Override
	public IUser getOwner() {
		return null;
	}

	@Override
	public Long getOwnerId() {
		return null;
	}

	@Override
	public int assignOwner(IUser owner) {
		return 0;
	}

	// //////////////////////////////////////

	/**
	 * @author awiovanna, tpatikorn override the equals function of object class
	 * @return true if user2 is an instance of IUser and this and user2 have the
	 *         same id, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof IUser) {
			return this.getId().equals(((IUser) o).getId());
		} else
			return false;
	}
}
