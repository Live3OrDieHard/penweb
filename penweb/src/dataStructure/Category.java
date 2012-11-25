package dataStructure;

import java.util.List;
import java.util.ArrayList;

import exceptions.DuplicateException;

/**
 * @author awiovanna, tpatikorn
 *
 * A category into which code examples can be placed
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
	public void addCodeExample(IExample example) throws DuplicateException{
		try{
			if(!this.hasExample(example)){
				this.exampleList.add(example);
				example.addCategory(this);
			}
		} catch (DuplicateException e) {
			throw e;
		}
	}


	/**
	 * helper function check if the category (this) is already has example
	 * 
	 * @param example the example wanted to be check
	 * @return true if the category already has example. false otherwise
	 */
	private boolean hasExample(IExample example) throws DuplicateException{
		ArrayList<IExample> examples = (ArrayList<IExample>)this.getExampleList();
		int i;
		for(i=0; i < examples.size(); i++){
			if(example.getId() == examples.get(i).getId()){
				throw new DuplicateException("This example has already been in the category.");
			}
		}
		return false;
	}

	@Override
	public List<IExample> getExampleList() {
		return exampleList;
	}

	@Override
	public int assignOwner(IUser owner) {
		if (this.owner != null)
			return 1; // return 1 if already assigned
		else
			this.owner = owner;
		return 0;
	}

	@Override
	public IUser getOwner() {
		return owner;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public Long getOwnerId() {
		return this.owner.getId();
	}

	@Override
	public int assignId(Long id) {
		if (this.id != -1L)
			return 1; // return 1 if already assigned
		else
			this.id = id;
		return 0;
	}


	@Override
	public List<Long> getExampleIds() {
		List<Long> ids = new ArrayList<Long>();
		for (IExample example : exampleList)
			ids.add(example.getId());
		return ids;
	}

	@Override
	public void removeExample(IExample example) {
		for(int i=this.exampleList.size()-1;i>=0;i--) {
			IExample ex = this.exampleList.get(i);
			if(ex.getId().equals(example.getId()))
				this.exampleList.remove(example);
		}
	}
	
	@Override
	public void removeAllExamples() {
		for(IExample ex: this.exampleList) {
			ex.removeFromCategory(this);
		}
		this.exampleList = new ArrayList<IExample>();
	}

	@Override
	public boolean isPublic() {
		return isPublic;
	}

	@Override
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
}
