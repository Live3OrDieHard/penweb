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
	Long getId();
	Long getOwnerId();
	/**
	 * assign an id (Long) to IEntry
	 * return 0 on success
	 * return 1 if the IEntry already has its id
	 */
	int assignID(Long id);
	/**
	 * assign an owner (IPerson) of IEntry
	 * return 0 on success
	 * return 1 if the IEntry is already assigned an owner
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
 *  
 */
