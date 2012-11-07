package dataStructure;

/**
 * 
 * @author Thanaporn
 * IExample is basically the actual entry (code/test/etc)
 * Prof. Pollice prefers to call it an example.
 */
public interface IExample extends IEntry
{
	/**
	 *{@link BasicExample#getHeader()}
	 */
	IHeader getHeader();
	
	/**
	 * {@link BasicExample#getContent()}
	 */
	IContent getContent();
	
	/**
	 * {@link BasicExample#getProperties()}
	 */
	IProperties getProperties();
	
	/**
	 * {@link BasicExample#setHeader(IHeader)}
	 */
	void setHeader(IHeader inHeader);
	
	/**
	 * {@link BasicExample#setContent(IContent)}
	 */
	void setContent(IContent inContent);
	
	/**
	 * {@link BasicExample#setProperties(IProperties)}
	 */
	void setProperties(IProperties inProperties);
}
