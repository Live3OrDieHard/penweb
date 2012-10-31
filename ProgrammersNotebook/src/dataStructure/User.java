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
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setUserID(int userid)
	{
		this.userid = userid;
	}
	
}
