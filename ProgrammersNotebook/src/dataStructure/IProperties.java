package dataStructure;

import java.util.ArrayList;

/**
 * 
 * different things might want different sets of properties...I think
 */
public interface IProperties 
{
	public String getLanguage();
	//public void setLanguage(String language);
	
	public String getSource();
	//public void setSource(String source);

	public ArrayList<Long> getCategories();
	public void setCategories(ArrayList<Long> categories);
	public void addCategory(Long categoryId);
	
	
}
