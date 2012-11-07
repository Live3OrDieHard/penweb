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
	private Long id;
	private IPerson owner;
	private ExampleProperties properties;
	private String title;
	
	/**
	 * Categories the example belongs to
	 */
	private ArrayList<Long> categoryIds = new ArrayList<Long>();
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
		id = -1L;
		authors = new LinkedList<IPerson>();
		owner = null;
		properties = new ExampleProperties();
	}
	
	public int assignID(Long id) {
		if (this.id != -1)
			return 1; // return 1 if already assigned
		else
			this.id = id;
		return 0;
	}

	public int assignOwner(IPerson owner) {
		if (this.owner != null)
			return 1; // return 1 if already assigned
		else
			this.owner = owner;
		return 0;
	}

	public List<IPerson> getAuthors() {
		return authors;
	}

	public void setAuthors(List<IPerson> authors) {
		this.authors = authors;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ExampleProperties getProperties() {
		return properties;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public IPerson getOwner() {
		return owner;
	}
	

	public void addCategory(long catId) {
		categoryIds.add(catId);
	}

	
	@Override
	/**
	 * 
	 */
	public Long getOwnerId() {
		return this.owner.getId();
	}
	
	public void setProperties(IProperties p)
	{
		this.properties.setLanguage(p.getLanguage());
		this.properties.setSource(p.getSource());
	}
	
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