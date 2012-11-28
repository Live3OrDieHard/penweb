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
 * @author awiovanna, tpatikorn
 * 
 *         A category into which code examples can be placed
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
		else
			throw new DuplicateException("This example is already in category:"+this.title);
	}

	/**
	 * helper function check if the category (this) is already has example
	 * 
	 * @param example
	 *            the example wanted to be check
	 * @return true if the category already has example. false otherwise
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

	/**
	 * The getter function to get the example list.
	 * @return
	 * 		  the examplelist
	 */
	@Override
	public List<IExample> getExampleList() {
		return exampleList;
	}

	/**
	 * The method is used to assign owner to 
	 * then category.
	 * 
	 * @param
	 * 		 owner the user will be assigned
	 * @return
	 * 		  1 if the category already has a owner
	 * 		  0 if the given user has been successfully
	 * 		  assigned to the category
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
	 * The getter function to get the owner of the category.
	 */
	@Override
	public IUser getOwner() {
		return owner;
	}

	/**
	 * The getter function to get the id of the category.
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/**
	 * The method is used to get the id of the owner of this category.
	 */
	@Override
	public Long getOwnerId() {
		return this.owner.getId();
	}

	/**
	 * The method is used to assign an id to the category.
	 * @return
	 * 		  1 if the category already has an id
	 *        0 the id is successfully assigned to the category
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
	 * The method is used to get a list of ids of the examples
	 * of the category.
	 * 
	 * @return
	 * 		  a list of ids of the examples of the category
	 */
	@Override
	public List<Long> getExampleIds() {
		List<Long> ids = new ArrayList<Long>();
		for (IExample example : exampleList)
			ids.add(example.getId());
		return ids;
	}

	/**
	 * The method is used to remove the example from the category.
	 * 
	 * @param
	 * 		 example the example will be removed from the category
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
	 * The method is used to remove all the examples from the category.
	 */
	@Override
	public void removeAllExamples() {
		for (IExample ex : this.exampleList) {
			ex.removeFromCategory(this);
		}
		this.exampleList = new ArrayList<IExample>();
	}

	/**
	 * THe method is used to show if the category is public.
	 * 
	 * @return
	 * 		  true is the category is public
	 */
	@Override
	public boolean isPublic() {
		return isPublic;
	}

	/**
	 * The method is used to set the public feature of the category.
	 * 
	 * @param
	 * 		 isPublic the boolean value is going to set for isPublic
	 * @return
	 * 		  the boolean valuse setted for isPublic
	 */
	@Override
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	@Override
	/**
	 * @author tpatikorn
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
	 * The method is used to get all the public examples in the category.
	 * 
	 * @return
	 * 		  the list of exmaples in the category that are public
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
	 * The method is used to get a list of examples that the user is 
	 * legally to see.
	 * 
	 * @param
	 * 		 user the current user using the method
	 * @return
	 * 		  a list of unique examples that the user has the right to get
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
}
