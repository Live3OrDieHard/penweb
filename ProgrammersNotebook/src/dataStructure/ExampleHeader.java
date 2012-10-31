package dataStructure;

import java.util.LinkedList;
import java.util.List;

public class ExampleHeader implements IHeader
{
	private String title;
	private List<IPerson> authors = new LinkedList<IPerson>();
	
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
	
	//just ONE NonUser name, please
	public ExampleHeader(String title, String name)
	{
		this.title = title;
		this.authors.add(new NonUser(name));
	}
}
