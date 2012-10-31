package dataStructure;

import java.util.LinkedList;
import java.util.List;

public class ExampleHeader implements IHeader
{
	private String title;
	private LinkedList<IPerson> authors;
	
	public String getTitle() 
	{
		return this.title;
	}
	
	public List<IPerson> getAuthors() 
	{
		return this.authors;
	}
	
}
