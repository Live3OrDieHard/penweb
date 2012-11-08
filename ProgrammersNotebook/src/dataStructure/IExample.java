package dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Thanaporn
 * IExample is basically the actual entry (code/test/etc)
 * Prof. Pollice prefers to call it an example.
 */

public interface IExample extends IEntry
{
	/**
	 * Update the example to have the given tag. All previous tags are kept.
	 * Tags won't be added if it's already added.
	 * @param tag The tag to add to the code example.
	 */
	public void addTags(String tag);

	/**
	 * Add the code example to the given category
	 * If the code is already in the category, nothing happens.
	 * @param category The category to add the code example to.
	 */
	public void addCategory(Category category);
	List<IPerson> getAuthors();

	/**
	 * Gets the list of categories the example belongs to.
	 * @return LinkedList<String>
	 */
	public ArrayList<Category> getCategories();

	/**
	 * Gets the list of tags the example has
	 * @return LinkedList<String>
	 */
	public ArrayList<String> getTags();
	String getCode();

	String getDescription();
	/**
	 * Gets the language the example was written in
	 * @return String
	 */
	public String getLanguage();
	IPerson getOwner();
	/**
	 * Gets the source of an example
	 * @return String
	 */
	public String getSource();
	
	String getTitle();
	void setAuthors(List<IPerson> a);

	/**
	 * A setter function to set example to belong to
	 * the given categories
	 * 
	 * @param tags
	 */
	public void setCategories(ArrayList<Category> categories);

	/**
	 * A setter function to set example to have the given tags
	 * 
	 * @param tags
	 */
	public void setTags(ArrayList<String> tags);
	void setCode(String code);
	void setDescription(String d);
	/**
	 * A setter function to set the language property of the example
	 * to the given language
	 * 
	 * @param language
	 */
	public void setLanguage(String language);
	/**
	 * A setter function to set the source property of the example
	 * to the given source
	 * 
	 * @param source
	 */
	public void setSource(String source);
	void setTitle(String t);
	BasicExample transferFromBuffer(BufferEntry e);
}