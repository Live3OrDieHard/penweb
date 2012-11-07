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

	public Category(String name, String description) {
		this.description = description;
		this.name = name;
		this.codeIds = new ArrayList<Long>();
		this.id = -1L;
		this.owner = null;
	}
	
	public IPerson getOwner() {
		return owner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see dataStructure.IEntry#getOwnerId()
	 */
	@Override
	public Long getOwnerId() {
		return owner.getId();
	}
	
	public void addCodeExample(IExample example) {
		codeIds.add(example.getId());
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
}
