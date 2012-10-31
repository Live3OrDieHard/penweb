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
	private LinkedList<String> tags = new LinkedList<String>();
	
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
	
	public void setLanguage(String language)
	{
		this.language = language;
	}
	
	public void setSource(String source)
	{
		this.source = source;
	}
	
	public void setTags(LinkedList<String> tags)
	{
		this.tags = tags;
	}
	
	public void addTag(String tag)
	{
		this.tags.add(tag);
	}
}
