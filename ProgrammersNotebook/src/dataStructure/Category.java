package dataStructure;

import java.util.List;
import java.util.ArrayList;

/**
 * @author awiovanna
 *
 * A category into which code examples can be placed
 */
public class Category implements ICategory {
	private IPerson owner;
	private String description;
	private String name;
	private List<IExample> exampleList;
	private Long id;

	public Category(IPerson owner, String description, String name) {
		this.owner = owner;
		this.description = description;
		this.name = name;
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
	 * @see dataStructure.ICategory#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 * @see dataStructure.ICategory#setName()
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @see dataStructure.ICategory#addCodeExample()
	 */
	public void addCodeExample(IExample example) {
		if(!this.hasExample(example))
		{
			this.exampleList.add(example);
			example.addCategory(this);
		}
	}

	/**
	 * helper function check if the category (this) is already has example
	 * 
	 * @param example the example wanted to be check
	 * @return true if the category already has example. false otherwise
	 */
	private boolean hasExample(IExample example) {
		for (int i = 0; i < this.exampleList.size(); i++) {
			if (this.exampleList.get(i).equals(example))
				return true;
		}
		return false;
	}

	/**
	 * @see dataStructure.IEntry#getOwnerId()
	 */
	public Long getOwnerId() {
		return owner.getId();
	}

	@Override
	public int assignOwner(IPerson owner) {
		if (this.owner != null)
			return 1; // return 1 if already assigned
		else
			this.owner = owner;
		return 0;
	}

	@Override
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
	public IPerson getOwner() {
		return owner;
	}
}
