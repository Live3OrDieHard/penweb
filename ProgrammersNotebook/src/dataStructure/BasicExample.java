package dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This is what the example should look like
 */
public class BasicExample implements IExample {

	private List<IPerson> authors;
	private String code;
	private String description;
	private IPerson owner;
	private ExampleProperties properties;
	private String title;
	
	/**
	 * Categories the example belongs to
	 */
	private ArrayList<Category> categoryList = new ArrayList<Category>();
	/**
	 * Language in which the example is written
	 */
	private String language;
	/**
	 * Where is the source of the example
	 */
	private String source;
	
	public BasicExample()
	{
		authors = new LinkedList<IPerson>();
		owner = null;
		properties = new ExampleProperties();
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
	public List<IPerson> getAuthors() {
		return authors;
	}

	@Override
	public void setAuthors(List<IPerson> authors) {
		this.authors = authors;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public ExampleProperties getProperties() {
		return properties;
	}
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public IPerson getOwner() {
		return owner;
	}
	

	public void addCategory(Category category) {
		categoryList.add(category);
		//check if it isn't there
		//TODO
		category.addCodeExample(this);
	}

	
	@Override
	/**
	 * 
	 */
	public Long getOwnerId() {
		return this.owner.getId();
	}
	
	@Override
	public void setProperties(IProperties p)
	{
		this.properties.setLanguage(p.getLanguage());
		this.properties.setSource(p.getSource());
	}
	
	@Override
	public BasicExample transferFromBuffer(BufferEntry e)
	{
		this.authors = e.getAuthors();
		this.code = e.getCode();
		this.description = e.getDescription();
		this.properties = e.getProperties();
		this.title = e.getTitle();
		return this;
	}

}
