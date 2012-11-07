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
	private Long id;
	private List<Long> codeIds;

	public Category(IPerson owner, String description, String name) {
		this.owner = owner;
		this.description = description;
		this.name = name;
		this.id = -1L;
		this.codeIds = new ArrayList<Long>();
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
		codeIds.add(example.getId());
	}

	/**
	 * @see dataStructure.IEntry#getEntryId()
	 */
	public Long getEntryId() {
		return id;
	}

	/**
	 * @see dataStructure.IEntry#getOwnerId()
	 */
	public Long getOwnerId() {
		return owner.getId();
	}
	
	@Override
	public int assignID(Long id) {
		if (this.id != -1)
			return 1; // return 1 if already assigned
		else
			this.id = id;
		return 0;
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
	public Long getId() {
		return this.id;
	}

}