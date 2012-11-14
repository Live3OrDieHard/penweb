package dataStructure;

import java.util.List;
import java.util.ArrayList;

/**
 * @author awiovanna
 *
 * A category into which code examples can be placed
 */
public class Category implements ICategory {
	private IUser owner;
	private String description;
	private String title;
	private List<IExample> exampleList;
	private Long id;
	private ArrayList<ICategory> dependency;
	
	public Category(String title, String description) {
		this.description = description;
		this.title = title;
		this.exampleList = new ArrayList<IExample>();
		this.id = -1L;
		this.dependency = new ArrayList<ICategory>();
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
	public void addCodeExample(IExample example) {
		if(!this.hasExample(example))
		{
			this.exampleList.add(example);
			example.addCategory(this);
		}
	}
	/**
	 * @author Peng Ren, Dennis Koufos
	 * Add dependencies to the given categories
	 * @param categories
	 */
	public void addDependency(ArrayList<ICategory> categories){
		int i;
		for(i=0; i < categories.size(); i++){
			dependency.add(categories.get(i));
		}
	}
	
	/**
	 * @author Peng Ren, Dennis Koufos
	 * get the categories' list that depend on each other
	 * @return
	 */
	public ArrayList<ICategory> getDependency(){
		return dependency;
	}
		

	/**
	 * helper function check if the category (this) is already has example
	 * 
	 * @param example the example wanted to be check
	 * @return true if the category already has example. false otherwise
	 */
	private boolean hasExample(IExample example) {
		return exampleList.contains(example);
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
}
