package dataStructure;

import java.util.LinkedList;
import java.util.List;

public class ExampleHeader implements IHeader
{
	private String title;
	private List<IPerson> authors;
	
	public String getTitle() 
	{
		return this.title;
	}
	
	public List<IPerson> getAuthors() 
	{
		return this.authors;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setAuthors(List<IPerson> authors)
	{
		this.authors = authors;
	}
	
	public void addAuthor(IPerson author)
	{
		this.authors.add(author);
	}
}
