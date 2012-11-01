package dataStructure;

/**
 * 
 * @author Thanaporn
 * IUser should be used to identify user
 * 
 */
public class User implements IPerson
{
/**
 * the name of the user
 */
	private String name;
/**
 * the user id number
 */
	private int userid;
/**
 * get the name of the user
 * @return String user's name
 */
	public String getName()
	{
		return this.name;
	}
/**
 * get the id number of the user
 * @return int user's id number
 */
	public int getUserID()
	{
		return this.userid;
	}
/**
 * set the given name for the user
 * @param String name
 */
	public void setName(String name)
	{
		this.name = name;
	}
/**
 * set up the user's id by given number
 * @param int user's id number
 */
	public void setUserID(int userid)
	{
		this.userid = userid;
	}
	
}
