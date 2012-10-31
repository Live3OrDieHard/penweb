package dataStructure;

/**
 * 
 * @author Thanaporn
 * IExample is basically the actual entry (code/test/etc)
 * Prof. Pollice prefers to call it an example.
 */

public interface IExample extends IEntry
{
	IHeader getHeader();
	IContent getContent();
	IProperties getProperties();
	void setHeader(IHeader inHeader);
	void setContent(IContent inContent);
	void setProperties(IProperties inProperties);
	/**
	 * @return a new object
	 */
	IExample makeExample(IHeader h, IContent c, IProperties p);
}
