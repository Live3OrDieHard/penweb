package dataStructure;

import java.util.LinkedList;

/**
 * 
 * @author Thanaporn
 * the fields are from Anjali's jar (for now)
 * 
 */
public class ExampleProperties implements IProperties
{
	private String language;
	private String source;
	private LinkedList<String> tags;
	
	public String getLanguage()
	{
		return this.language;
	}
	
	public String getSource()
	{
		return this.source;
	}
	
	public LinkedList<String> getTags()
	{
		return this.tags;
	}
}
