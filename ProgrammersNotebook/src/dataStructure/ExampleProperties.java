package dataStructure;

import java.util.ArrayList;

/**
 * @author Thanaporn
 * Properties about an example. 
 */
public class ExampleProperties implements IProperties
{
	/**
	 * Language in which the example is written
	 */
	private String language;
	
	/**
	 * Where is the source of the example
	 */
	private String source;
	
	/**
	 * Categories the example belongs to
	 */
	private ArrayList<Long> categoryIds = new ArrayList<Long>();

	/**
	 * Gets the language the example was written in
	 * @return String
	 */
	public String getLanguage()
	{
		return this.language;
	}

	/**
	 * Gets the source of an example
	 * @return String
	 */
	public String getSource()
	{
		return this.source;
	}

	/**
	 * Gets the list of categories the example belongs to.
	 * @return LinkedList<String>
	 */
	public ArrayList<Long> getCategories()
	{
		return this.categoryIds;
	}

	/**
	 * A setter function to set the language property of the example
	 * to the given language
	 * 
	 * @param language
	 */
	public void setLanguage(String language)
	{
		this.language = language;
	}

	/**
	 * A setter fucntion to set the source property of the example
	 * to the given source
	 * 
	 * @param source
	 */
	public void setSource(String source)
	{
		this.source = source;
	}

	/**
	 * A setter function to set the tag property of the example 
	 * to the given categories.
	 * 
	 * @param tags
	 */
	public void setCategories(ArrayList<Long> categories)
	{
		this.categoryIds = categories;
	}

	/**
	 * Add the given category to the example
	 * 
	 * @param tag
	 */
	public void addCategory(Long categoryId)
	{
		this.categoryIds.add(categoryId);
		//TODO: The category itself should also store a reference to the example
		//cg = db.getCategoryById(categoryId)
		//cg.addEntry(this.getId);
	}
}
