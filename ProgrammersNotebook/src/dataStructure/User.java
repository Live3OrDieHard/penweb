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
	
	@Override
	public String getName()
	{
		return this.name;
	}
	
	@Override
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
