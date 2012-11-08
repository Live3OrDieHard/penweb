package dataStructure;

/**
 * @author Thanaporn
 * 
 * This should refer to a person
 * IUser, IAdmin, INonUser
 */
public interface IPerson 
{
	/**
	 * @return The name of the person as a String.
	 */
	String getName();

	/**
	 * @param name The new name for a person. Fails if the person already has a name.
	 */
	void assignName(String name);
}
