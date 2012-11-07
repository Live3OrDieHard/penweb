package dataStructure;

import java.util.ArrayList;

/**
 * 
 * @author Thanaporn
 * the fields are from Anjali's jar (for now)
 * 
 */
public class ExampleProperties implements IProperties
{
	/**
	 * language in which the example is written
	 */
	private String language;
	/**
	 * where is the source of the example
	 */
	private String source;
	/**
	 * all the tags include in the example
	 */
	private ArrayList<Long> categoryIds = new ArrayList<Long>();

	/**
	 * a getter function to get the language property of the example
	 * @return String
	 */
	public String getLanguage()
	{
		return this.language;
	}

	/**
	 * a getter function to get the source function for the example
	 * @return String
	 */
	public String getSource()
	{
		return this.source;
	}

	/**
	 * a getter function to get the tags of the example	
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
	 * A setter function to set the source property of the example
	 * to the given source
	 * 
	 * @param source
	 */
	public void setSource(String source)
	{
		this.source = source;
	}

	/**
	 * a setter function to set the tag property of the example 
	 * to the given tags
	 * 
	 * @param tags
	 */
	public void setCategories(ArrayList<Long> categories)
	{
		this.categoryIds = categories;
	}

	/**
	 * add the given tag to the example
	 * 
	 * @param tag
	 */
	public void addCategory(Long categoryId)
	{
		this.categoryIds.add(categoryId);
		//cg = db.getCategoryById(categoryId)
		//cg.addEntry(this.getId);
		
	}
}
