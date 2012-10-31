package dataStructure;

import java.util.List;

/**
 * 
 * @author Thanaporn
 * An instance of IHeader should contains data that identify the IEntry
 * (like name and author/owner)
 * IHeader should give IEntry uniqueness.
 */
public interface IHeader 
{
	/* I don't think we need an interface ITitle
	 * I think String should be enough.
	 */
	//IName getTitle();
	
	String getTitle();
	
	/*
	 * It's better to be an object so we'll be able to associate
	 * this field to user data (personal folder and stuff)
	 * I use IPerson instead of IUser because there might be
	 * some codes from non-users.
	 */
	List<IPerson> getAuthors();
}
