package dataStructure;

/**
 * 
 * @author Thanaporn
 * IEntry should an entry
 * covering anything from examples/codes/tests to folders
 * 
 */
public interface IEntry 
{
	IHeader getHeader();
	IContent getContent();

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
