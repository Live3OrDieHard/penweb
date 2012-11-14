package dataStructure;

import java.util.List;

/**
 * @author Thanaporn
 * @author jfchines
 * @author awiovanna
 * 
 * This should refer to a person
 * IUser, IAdmin, INonUser
 */
public interface IUser extends IEntry
{
	/**
	 * @return The name the user will use to log in
	 */
	String getLoginName();
	
	/**
	 * @return The name of the person as a String.
	 */
	String getDisplayName();
	
	/**
	 * @param name The new name for a person. Fails if the person already has a name.
	 */
	void changeDisplayName(String displayName);
	
	/**
	 * Checks whether the given password matches one for the user
	 * @param passwordAttempt The password entered on the website
	 * @return True if the password is correct. False otherwise.
	 */
	Boolean checkPassword(String passwordAttempt);
	
	/**
	 * @param newPassword The new password for the user.
	 */
	void changePassword(String oldPassword, String newPassword, String reenterNew);
	
	/**
	 * Adds an example to a user's list of owned examples
	 * @param example The example to add
	 */
	void addOwnedExample(IExample example);

	/**
	 * @return The list of examples a user owns
	 */
	List<IExample> getOwnedExampleList();
	
	/**
	 * Adds a category to a user's list of owned category
	 * @param category
	 */
	void addOwnedCategory(ICategory category);
	
	/**
	 * @return The list of categories a user owns
	 */
	List<ICategory> getOwnedCategoryList();
}
