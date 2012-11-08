package dataStructure;

/**
 * @author Thanaporn
 * IEntry should be an entry
 * covering anything from examples/codes/tests to folders
 * 
 */
public interface IEntry 
{	
	/**
	 * @return The owner of an entry.
	 */
	IPerson getOwner();
	
	/**
	 * Assigns an owner for an entry. It will do nothing if the entry already has an owner
	 * @param owner The person who will own the entry
	 * @return 0 if success, 1 if entry already has an owner
	 */
	int assignOwner(IPerson owner);
}

/*
 * I think we need this because a folder/package is an entry (sort of)
 * but IExample is defined as something like codes or tests (with authors and metadata)
 * while something like folders don't.
 * If anyone has a good reason we should keep/delete this interface, please tell me.
 * (I myself am not sure if this interface is really neccessary)
 *  -March (Thanaporn)
 */