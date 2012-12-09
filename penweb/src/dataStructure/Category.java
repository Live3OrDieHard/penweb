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
import java.util.ArrayList;

import exceptions.DuplicateException;

/**
 * @author awiovanna
 * @author tpatikorn
 * 
 * A category into which code examples can be placed
 * Contains methods to get/set the description, title,
 * id, public of a category. Also can add/remove examples.
 */
public class Category implements ICategory {
	private IUser owner;
	private String description;
	private String title;
	private List<IExample> exampleList;
	private Long id;
	private boolean isPublic;

	public Category(String title, String description) {
		this.description = description;
		this.title = title;
		this.exampleList = new ArrayList<IExample>();
		this.id = -1L;
	}

	/**
	 * @see dataStructure.ICategory#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @see dataStructure.ICategory#setDescription()
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @see dataStructure.ICategory#getTitle()
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @see dataStructure.ICategory#setTitle()
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @see dataStructure.ICategory#addCodeExample()
	 */
	public void addCodeExample(IExample example) throws DuplicateException {
		if (!this.hasExample(example)) {
			this.exampleList.add(example);
			if(!example.getCategories().contains(this))
				example.addCategory(this);
		}
		else {
			throw new DuplicateException("This example is already in category:"+this.getTitle());
		}
	}

	/**
	 * @see dataStructure.ICategory#getExampleList()
	 */
	@Override
	public List<IExample> getExampleList() {
		return exampleList;
	}

	/**
	 * @see dataStructure.IEntry#assignOwner(IUser)
	 */
	@Override
	public int assignOwner(IUser owner) {
		if (this.owner != null)
			return 1; // return 1 if already assigned
		else
			this.owner = owner;
		return 0;
	}

	/**
	 * @see dataStructure.IEntry#getOwner()
	 */
	@Override
	public IUser getOwner() {
		return owner;
	}

	/**
	 * @see dataStructure.IEntry#getId()
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/**
	 * @see dataStructure.IEntry#getOwnerId()
	 */
	@Override
	public Long getOwnerId() {
		return this.owner.getId();
	}

	/**
	 * @see dataStructure.IEntry#assignId(Long)
	 */
	@Override
	public int assignId(Long id) {
		if (this.id != -1L)
			return 1; // return 1 if already assigned
		else
			this.id = id;
		return 0;
	}

	/**
	 * @see dataStructure.ICategory#getExampleIds()
	 */
	@Override
	public List<Long> getExampleIds() {
		List<Long> ids = new ArrayList<Long>();
		for (IExample example : exampleList)
			ids.add(example.getId());
		return ids;
	}

	/**
	 * @see dataStructure.ICategory#removeExample(IExample)
	 */
	@Override
	public void removeExample(IExample example) {
		for (int i = this.exampleList.size() - 1; i >= 0; i--) {
			IExample ex = this.exampleList.get(i);
			if (ex.getId().equals(example.getId()))
				this.exampleList.remove(example);
		}
	}

	/**
	 * @see dataStructure.ICategory#removeAllExamples()
	 */
	@Override
	public void removeAllExamples() {
		for (IExample ex : this.exampleList) {
			ex.removeFromCategory(this);
		}
		this.exampleList = new ArrayList<IExample>();
	}

	/**
	 * @see dataStructure.ICategory#isPublic()
	 */
	@Override
	public boolean isPublic() {
		return isPublic;
	}

	/**
	 * @see dataStructure.ICategory#setPublic(boolean)
	 */
	@Override
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	@Override
	/**
	 * override the equals function of object class
	 * @return true if o is an instance of ICategory and
	 *         this and o have the same id, false otherwise.
	 */
	public boolean equals(Object o) {
		if (o instanceof ICategory) {
			return this.getId().equals(((ICategory) o).getId());
		} else
			return false;
	}

	/**
	 * @see dataStructure.ICategory#getPublicExamples()
	 */
	@Override
	public List<IExample> getPublicExamples() {
		ArrayList<IExample> results = new ArrayList<IExample>();
		for (IExample example : this.exampleList) {
			if (example.isPublic())
				results.add(example);
		}

		return results;
	}

	/**
	 * @see dataStructure.ICategory#getVisibleExamples(IUser)
	 */
	@Override
	public List<IExample> getVisibleExamples(IUser user) {
		List<IExample> results = getPublicExamples();
		for (IExample example : this.exampleList) {
			if (example.getOwnerId() == user.getId() && !results.contains(example))
				results.add(example);
		}

		return results;
	}

	/**
	 * @see dataStructure.ICategory#getOwnedExamples(IUser)
	 */
	@Override
	public List<IExample> getOwnedExamples(IUser user) {
		List<IExample> results = new ArrayList<IExample>();

		for (IExample example : exampleList) {
			if (example.getOwner() == user) {
				results.add(example);
			}
		}

		return results;
	}

	/**
	 * Helper function check if the category (this) is already has example
	 * 
	 * @param example The example wanted to be check
	 * @return True if the category already has example. False otherwise.
	 */
	private boolean hasExample(IExample example) {
		ArrayList<IExample> examples = (ArrayList<IExample>) this
				.getExampleList();
		int i;
		for (i = 0; i < examples.size(); i++) {
			if (example.getId() == examples.get(i).getId()) {
				return true;
			}
		}
		return false;
	}
}
