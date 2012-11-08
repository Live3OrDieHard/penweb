package dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thanaporn
 * IExample is basically the actual entry (code/test/etc)
 * Prof. Pollice prefers to call it an example.
 */
public interface IExample extends IEntry
{
	/**
	 * Add the code example to the given category
	 * If the code is already in the category, nothing happens.
	 * @param category The category to add the code example to.
	 */
	public void addCategory(Category category);
	
	/**
	 * Update the example to have the given tag. All previous tags are kept.
	 * Tags won't be added if it's already added.
	 * @param tag The tag to add to the code example.
	 */
	public void addTags(String tag);
	
	/**
	 * @return List of authors
	 */
	List<IPerson> getAuthors();

	/**
	 * Gets the list of categories the example belongs to.
	 * @return ArrayList<Category>
	 */
	public ArrayList<Category> getCategories();

	/**
	 * @return The code in the example as a String
	 */
	String getCode();

	/**
	 * @return The description of an example
	 */
	String getDescription();
	
	/**
	 * Gets the language the example was written in
	 * @return String represent language of example
	 */
	public String getLanguage();
	
	/**
	 * @return The person who 'owns' this example
	 */
	IPerson getOwner();

	/**
	 * Gets the source of an example
	 * @return String
	 */
	public String getSource();
	
	/**
	 * Gets the list of tags the example has
	 * @return LinkedList<String>
	 */
	public ArrayList<String> getTags();

	/**
	 * @return The title of an example
	 */
	String getTitle();
	
	/**
	 * @param a List<IPerson>: A list of authors
	 */
	void setAuthors(List<IPerson> a);
	
	/**
	 * A setter function to set example to belong to
	 * the given categories
	 * @param tags
	 */
	public void setCategories(ArrayList<Category> categories);

	/**
	 * @param code The code content to be associated with an example
	 */
	void setCode(String code);

	/**
	 * @param d String: A new description
	 */
	void setDescription(String d);
	
	/**
	 * A setter function to set the language property of the example
	 * to the given language
	 * @param language
	 */
	public void setLanguage(String language);
	
	/**
	 * A setter function to set the source property of the example
	 * to the given source
	 * @param source
	 */
	public void setSource(String source);
	
	/**
	 * A setter function to set example to have the given tags
	 * @param tags
	 */
	public void setTags(ArrayList<String> tags);
	
	/**
	 * @param t String: a new title
	 */
	void setTitle(String t);
	
	/**
	 * @param e A BufferEntry containing information about an example
	 * @return A BasicExample created using information in the BufferEntry
	 */
	BasicExample transferFromBuffer(BufferEntry e);
}
