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
	 * @return The ID of the person as a Long. Everything in the DB has an ID.
	 */
	Long getId();

	void assignName(String name);
}
