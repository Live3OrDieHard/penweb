package dataStructure;

public interface ICategory extends IEntry{
	/**
	 * @return Returns the name of the category. For example: "Web" or "Mobile".
	 */
	String getName();
	
	/**
	 * Sets the name of a category.
	 * @param name The name of the category
	 */
	void setName(String name);
	
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
	 */
	void addCodeExample(IExample example);
}
