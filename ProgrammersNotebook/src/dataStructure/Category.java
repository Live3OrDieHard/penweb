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
	private Long categoryId;
	private List<Long> codeIds;

	public Category(IPerson owner, String description, String name) {
		this.owner = owner;
		this.description = description;
		this.name = name;
		this.categoryId = (long)(Math.random() * 1000000);
		this.codeIds = new ArrayList<Long>();
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

	public Long getEntryId() {
		return categoryId;
	}

	/* (non-Javadoc)
	 * @see dataStructure.IEntry#getOwnerId()
	 */
	@Override
	public Long getOwnerId() {
		return owner.getId();
	}
	
	public void addCodeExample(IExample example) {
		codeIds.add(example.getEntryId());
	}
}
