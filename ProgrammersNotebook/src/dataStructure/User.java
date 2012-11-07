package dataStructure;

/**
 * @author Thanaporn
 * IUser should be used to identify user
 */
public class User implements IPerson
{
	/**
	 * The name of the user
	 */
	private String name;
	
	/**
	 * The user id number
	 */
	private Long userId;
	
	@Override
	/**
	 * Get the name of the user
	 * @return String user's name
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Get the id number of the user
	 * @return Long user's id number
	 */
	public Long getId()
	{
		return this.userId;
	}
	
	@Override
	/**
	 * Set the given name for the user
	 * @param String name
	 */
	public void assignName(String name)
	{
		if(this.name!=null)
		{
			//throw exception
		}
		else 
			this.name = name;
	}	
}
