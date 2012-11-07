package dataStructure;

import java.util.ArrayList;

/**
 * Getters and setters for managing properties of an example
 */
public interface IProperties 
{
	public String getSource();
	public ArrayList<Long> getCategories();
	public void setLanguage(String language);
	public void setSource(String source);
	public void setCategories(ArrayList<Long> categories);
	public void addCategory(Long categoryId);
	
}
