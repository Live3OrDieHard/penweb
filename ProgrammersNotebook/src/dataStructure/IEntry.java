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
	 * @return a unique ID associated with the entry
	 */
	Long getId();
	
	/**
	 * @return The ID of the owner of an entry.
	 */
	Long getOwnerId();
	
	/**
	 * Assigns an owner for an entry. It will do nothing if the entry already has an owner
	 * @param owner The person who will own the entry
	 * @return 0 if success, 1 if entry already has an owner
	 */
	int assignOwner(IPerson owner);

	/**
	 * @param id The id for the entry
	 * @return 0 if success, 1 otherwise.
	 */
	int assignId(Long id);
}

/*
 * I think we need this because a folder/package is an entry (sort of)
 * but IExample is defined as something like codes or tests (with authors and metadata)
 * while something like folders don't.
 * If anyone has a good reason we should keep/delete this interface, please tell me.
 * (I myself am not sure if this interface is really neccessary)
 *  -March (Thanaporn)
 */