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
	private ArrayList<Category> categoryList = new ArrayList<Category>();
	
	@Override
	/**
	 * Gets the language the example was written in
	 * @return String
	 */
	public String getLanguage()
	{
		return this.language;
	}
	
	@Override
	/**
	 * Gets the source of an example
	 * @return String
	 */
	public String getSource()
	{
		return this.source;
	}
	
	@Override
	/**
	 * Gets the list of categories the example belongs to.
	 * @return LinkedList<String>
	 */
	public ArrayList<Category> getCategories()
	{
		return this.categoryList;
	}

	@Override
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

	@Override
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

	@Override
	/**
	 * A setter function to set the tag property of the example 
	 * to the given categories.
	 * 
	 * @param tags
	 */
	public void setCategories(ArrayList<Category> categories)
	{
		this.categoryList = categories;
	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		
	}
}
