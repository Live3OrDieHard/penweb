package dataStructure;

/**
 * 
 * @author Thanaporn
 * IUser should be used to identify user
 * 
 */
public class User implements IPerson
{
	private String name;
	private int userid;
	
	public String getName()
	{
		return this.name;
	}
	
	public int getUserID()
	{
		return this.userid;
	}
	
}
