package dataStructure;

import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author team3
 *
 * The ExampleHeader class describes the header of the
 * examples and let user to access and edit the data
 * of the header
 */
public class ExampleHeader implements IHeader
{
/**
 * the title of the header
 */
	private String title;
/**
 * the authors of the examples
 */
	private List<IPerson> authors = new LinkedList<IPerson>();
/**
 * The getter function to get the title of the example
 * @return String
 */
	public String getTitle() 
	{
		return this.title;
	}
/**
 * the getter function to get the authors of the examples
 * @return List<IPerson>
 */
	public List<IPerson> getAuthors() 
	{
		return this.authors;
	}
/**
 * set the title of the example to the given string
 * @param String title
 */
	public void setTitle(String title)
	{
		this.title = title;
	}
/**
 *set the authors of the example to the given authors
 *@param List<IPerson> The authors for the example
 */
	public void setAuthors(List<IPerson> authors)
	{
		this.authors = authors;
	}
/**
 * add a given author to the example's header
 * @param author a new author
 */
	public void addAuthor(IPerson author)
	{
		this.authors.add(author);
	}
/**
 * default constructor for the ExampleHeader class
 * set the default author to be one NonUser
 */
	//just ONE NonUser name, please
	public ExampleHeader(String title, String name)
	{
		this.title = title;
		this.authors.add(new NonUser(name));
	}
}
