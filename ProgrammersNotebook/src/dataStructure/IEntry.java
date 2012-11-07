package dataStructure;

/**
 * 
 * @author Thanaporn
 * IEntry should be an entry
 * covering anything from examples/codes/tests to folders
 * 
 */
public interface IEntry 
{
	/**
	 * @return Returns the ID of an entry in the database. Every entry has an ID.
	 */
	Long getEntryId();
	
	/**
	 * @return The ID of the owner of an entry.
	 */
	Long getOwnerId();
}

/*
 * I think we need this because a folder/package is an entry (sort of)
 * but IExample is defined as something like codes or tests (with authors and metadata)
 * while something like folders don't.
 * If anyone has a good reason we should keep/delete this interface, please tell me.
 * (I myself am not sure if this interface is really neccessary)
 *  -March (Thanaporn)
 *  
 */
