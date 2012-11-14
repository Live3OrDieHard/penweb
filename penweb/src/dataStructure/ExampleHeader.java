package dataStructure;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tpatikorn
 *
 * The ExampleHeader class describes the header of the
 * examples and let user to access and edit the data
 * of the header
 * ***No longer used***
 */
public class ExampleHeader implements IHeader
{
	/**
	 * The title of the header
	 */
	private String title;
	
	/**
	 * The author(s) of the examples
	 */
	private List<IUser> authors = new LinkedList<IUser>();
	
	/**
	 * @see dataStructure.IHeader#getTitle()
	 */
	public String getTitle() 
	{
		return this.title;
	}
	
	/**
	 * @see dataStructure.IHeader#getAuthors()
	 */
	public List<IUser> getAuthors() 
	{
		/*
		 * It's better to be an object so we'll be able to associate
		 * this field to user data (personal folder and stuff)
		 * I use IPerson instead of IUser because there might be
		 * some codes from non-users.
		 */
		return this.authors;
	}
	
	/**
	 * @see dataStructure.IHeader#setTitle(String)
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/**
	 * @see dataStructure.IHeader#setAuthors(List)
	 */
	public void setAuthors(List<IUser> authors)
	{
		this.authors = authors;
	}
	
	/**
	 * Add a given author to the example's header
	 * @param author a new author
	 */
	public void addAuthor(IUser author)
	{
		this.authors.add(author);
	}
	
	/**
	 * Default constructor for the ExampleHeader class
	 * Set the default author to be one NonUser
	 */
	public ExampleHeader(String title, String name) //just ONE NonUser name, please
	{
		
		this.title = title;
		// Change this to accept an actual author object
		this.authors.add(new User("", "", ""));
	}
}
