package dataStructure;

/**
 * 
 * @author Thanaporn
 * for non-user people involved
 * e.g. authors that are not users
 */
public class NonUser implements IPerson
{
	private String name;
	//might want this later
	//int refNumber;

	public NonUser(String name) 
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}
}
