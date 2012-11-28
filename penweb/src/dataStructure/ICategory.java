package dataStructure;

import java.util.List;

import exceptions.DuplicateException;

/**
 * 
 * @author tpatikorn
 * an interface for a category, in case there are more category types.
 *
 */
import exceptions.DuplicateException;

public interface ICategory extends IEntry{
	
	/**
	 * @return Returns the title of the category. For example: "Web" or "Mobile".
	 */
	String getTitle();
	
	/**
	 * Sets the title of a category.
	 * @param title The title of the category
	 */
	void setTitle(String title);
	
	/**
	 * @return Returns the description of a category.
	 */
	String getDescription();
	
	/**
	 * Sets a description of a category.
	 * @param description The new description
	 */
	void setDescription(String description);
	
	/**
	 * Adds a new example to this category.
	 * @param example The example entry to add.
	 * @throws DuplicateException 
	 */
	void addCodeExample(IExample example) throws DuplicateException;

	List<IExample> getExampleList();
	
	List<Long> getExampleIds();

	void removeExample(IExample example);

	void removeAllExamples();
	
	public boolean isPublic();

	public void setPublic(boolean isPublic);
	
	List<IExample> getPublicExamples();
	
	List<IExample> getVisibleExamples(IUser user);
}
