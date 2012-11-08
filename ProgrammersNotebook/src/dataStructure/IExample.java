package dataStructure;

import java.util.List;

/**
 * @author Thanaporn
 * IExample is basically the actual entry (code/test/etc)
 * Prof. Pollice prefers to call it an example.
 */
public interface IExample extends IEntry
{
	/**
	 * @return The title of an example
	 */
	String getTitle();
	
	/**
	 * @param t String: a new title
	 */
	void setTitle(String t);

	/**
	 * @return List of authors
	 */
	List<IPerson> getAuthors();
	
	/**
	 * @param a List<IPerson>: A list of authors
	 */
	void setAuthors(List<IPerson> a);

	/**
	 * @return The description of an example
	 */
	String getDescription();
	
	/**
	 * @param d String: A new description
	 */
	void setDescription(String d);

	/**
	 * @return An object containing the properties of an example
	 */
	IProperties getProperties();

	/**
	 * @param inProperties New properties for the example
	 */
	void setProperties(IProperties inProperties);
	
	/**
	 * @return The person who 'owns' this example
	 */
	IPerson getOwner();
	
	/**
	 * @param e A BufferEntry containing information about an example
	 * @return A BasicExample created using information in the BufferEntry
	 */
	BasicExample transferFromBuffer(BufferEntry e);
	
	/**
	 * @return The code in the example as a String
	 */
	String getCode();
	
	/**
	 * @param code The code content to be associated with an example
	 */
	void setCode(String code);
	
	/**
	 * Adds the example to the given category
	 * @param category The category the code example should be added to
	 */
	void addCategory(ICategory category);
	
	/**
	 * @return The list of categories that an example belongs to
	 */
	List<ICategory> getCategories();
}