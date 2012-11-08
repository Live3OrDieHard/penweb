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

	public Category(IPerson owner, String description, String name) {
		this.owner = owner;
		this.description = description;
		this.name = name;
		this.exampleList = new ArrayList<IExample>();
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
		if (!exampleList.contains(example))
		{
			this.exampleList.add(example);
			example.getProperties().addCategory(this);
		}
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
	public IPerson getOwner() {
		return owner;
	}
}
