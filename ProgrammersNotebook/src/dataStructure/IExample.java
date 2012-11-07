package dataStructure;

import java.util.List;

/**
 * 
 * @author Thanaporn
 * IExample is basically the actual entry (code/test/etc)
 * Prof. Pollice prefers to call it an example.
 */

public interface IExample extends IEntry
{
	String getTitle();
	void setTitle(String t);
	
	List<IPerson> getAuthors();
	void setAuthors(List<IPerson> a);
	
	String getDescription();
	void setDescription(String d);
	
	IProperties getProperties();
	void setProperties(IProperties inProperties);
}
