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
	private ArrayList<ICategory> categoryList = new ArrayList<ICategory>();
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
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int assignOwner(IPerson owner) {
		if (this.owner != null)
			return 1; // return 1 if already assigned
		else
			this.owner = owner;
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IPerson> getAuthors() {
		return authors;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAuthors(List<IPerson> authors) {
		this.authors = authors;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCode() {
		return code;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExampleProperties getProperties() {
		return properties;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IPerson getOwner() {
		return owner;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addCategory(ICategory category) {
		if (!categoryList.contains(category))
		{
			categoryList.add(category);
			category.addCodeExample(this);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<ICategory> getCategories() {
		return categoryList;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setProperties(IProperties p)
	{
		this.properties.setLanguage(p.getLanguage());
		this.properties.setSource(p.getSource());
	}
	
	/**
	 * {@inheritDoc}
	 */
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
