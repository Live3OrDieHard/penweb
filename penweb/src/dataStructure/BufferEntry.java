package dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tpatikorn
 * This object will accumulate all fields of all kind of IEntry
 * to be a buffer entry
 * this should help web app - controller interaction
 * (web app only need to send data once using this buffer)
 */
public class BufferEntry 
{

	private String categoryName;

	private ArrayList<String> categoryNameList;

	private String comment;

	/**
	 * help the web controller to get the cateogory name
	 * @return
	 * 		  the name of category
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * helpe the web controller to get a list of category names
	 * @return
	 * 		  a list of names of categories
	 */
	public ArrayList<String> getCategoryNameList() {
		return categoryNameList;
	}
	/**
	 * the default setter method to set the categoryNameList
	 * @param categoryNameList
	 */

	public void setCategoryNameList(ArrayList<String> categoryNameList) {
		this.categoryNameList = categoryNameList;
	}

	/**
	 * The method is used to add a new category name to the category name list
	 * @param 
	 * 		 a new category name
	 */
	public void addCategoryNameList(String categoryName) {
		this.categoryNameList.add(categoryName);
	}

	/**
	 * The default setter method to set the category name.
	 * @param categoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	private ArrayList<IUser> authors;
	/**
	 * Categories the example belongs to
	 */
	private ArrayList<Category> categories = new ArrayList<Category>();

	private String code;

	private String description;

	/**
	 * Language in which the example is written
	 */
	private String language;

	private IUser owner;

	private ExampleProperties properties;
	/**
	 * Where is the source of the example
	 */
	private String source;
	private String title;

	/**
	 * This is the default constructor for BuffferEntry class
	 * Every time the Bufferentry is set up, it automatically
	 * create a new list of authors and a new list of categories
	 * for the web controller to use
	 */
	public BufferEntry() {
		this.authors = new ArrayList<IUser>();
		this.categories = new ArrayList<Category>();
	}

	/**
	 * Add a new author to the author list
	 * @param a new user
	 */
	public void addAuthor(IUser person) {
		this.authors.add(person);
	}

	/**
	 * Add a new category to the categor list
	 * @param a new category
	 */
	public void addCategory(Category category) {
		this.categories.add(category);
	}

	/**
	 * The getter function for web controller to
	 * get the author list
	 * @return
	 * 		  a list of all authors
	 */
	public ArrayList<IUser> getAuthors() {
		return authors;
	}

	/**
	 * The getter function for web controller to
	 * get the category list
	 * @return
	 * 		  a list of all categories
	 */
	public ArrayList<Category> getCategories() {
		return categories;
	}

	/**
	 * The getter function for web controller to 
	 * get code content
	 * @return
	 * 		  the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * The getter function for web controller to 
	 * get descritpion for the entry
	 * @return
	 * 		  the description for the entry
	 */
	public String getDescription() {
		return description;
	}	

	/**
	 * The getter function to get the language written 
	 * the code in the form of lowercase format
	 * @return
	 * 		  the language used to write code in lower case
	 */
	public String getLanguage() {
		return language.toLowerCase();
	}

	/**
	 * The getter function for web controller to 
	 * get the entry owner
	 * @return
	 * 		  the owner for the code
	 */
	public IUser getOwner() {
		return owner;
	}

	/**
	 * The getter function to get the property of the entry
	 * @return
	 * 		  the property of the entry
	 */
	public ExampleProperties getProperties() {
		return properties;
	}
	/**
	 * THe getter function to get the source of the
	 * example.
	 * @return
	 * 		  the source of the example
	 */
	public String getSource() {
		return source;
	}

	/**
	 * The getter function to get the title of the 
	 * example.
	 * @return
	 * 		  the title of the example
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * The setter function to set the author list.
	 * @param 
	 * 		 a list of  authors
	 */
	public void setAuthors(ArrayList<IUser> authors) {
		this.authors = authors;
	}

	/**
	 * The setter function to set the category list.
	 * @param 
	 * 		 a list of categories
	 */
	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

	/**
	 * The setter function to set the code content of example.
	 * @param 
	 * 		 code contained in an example
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * The setter function to set the description of example.
	 * @param 
	 * 		 the description of an example
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * The setter function to set the language of an example.
	 * @param 
	 *  	 the language of an example
	 */
	public void setLanguage(String language) {
		this.language = language.toLowerCase();
	}

	/**
	 * THe setter function to set the owner of an example.
	 * @param 
	 * 		 the owner of an example
	 */
	public void setOwner(IUser owner) {
		this.owner = owner;
	}

	/**
	 * The setter function to set the properties of examples
	 * @param 
	 * 		 a list of properties for examples
	 */
	public void setProperties(ExampleProperties properties) {
		this.properties = properties;
	}

	/**
	 * The setter function to set the source of an example.
	 * @param 
	 * 		 the source of an example
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * The setter funtion ot set the title of an example.
	 * @param 
	 * 		 the title of an example
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * The getter function to get the comment of an example.
	 * @return
	 * 		  the comment of an example
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * The setter function to set the comment of an example
	 * @param 
	 * 		 the comment of an example
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
