package dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Thanaporn
 *
 * This object will accumulate all fields of all kind of IEntry
 * to be a buffer entry
 * this should help web app - controller interaction
 * (web app only need to send data once using this buffer)
 */
public class BufferEntry 
{
	private List<IPerson> authors;
	/**
	 * Categories the example belongs to
	 */
	private ArrayList<Long> categoryIds = new ArrayList<Long>();
	
	private String code;

	private String description;

	private Long id; //shouldn't have an id. It's server-side

	/**
	 * Language in which the example is written
	 */
	private String language;

	private IPerson owner;

	private ExampleProperties properties;
	/**
	 * Where is the source of the example
	 */
	private String source;
	private String title;
	
	public BufferEntry() {
		this.authors = new ArrayList<IPerson>();
		this.categoryIds = new ArrayList<Long>();
	}
	public void addAuthor(IPerson person) {
		this.authors.add(person);
	}
	
	public void addCategoryIds(Long catId) {
		this.categoryIds.add(catId);
	}
	
	public List<IPerson> getAuthors() {
		return authors;
	}
	public ArrayList<Long> getCategoryIds() {
		return categoryIds;
	}
	public String getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getLanguage() {
		return language;
	}
	public IPerson getOwner() {
		return owner;
	}
	public ExampleProperties getProperties() {
		return properties;
	}
	public String getSource() {
		return source;
	}
	public String getTitle() {
		return title;
	}
	public void setAuthors(List<IPerson> authors) {
		this.authors = authors;
	}
	public void setCategoryIds(ArrayList<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setOwner(IPerson owner) {
		this.owner = owner;
	}
	public void setProperties(ExampleProperties properties) {
		this.properties = properties;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
