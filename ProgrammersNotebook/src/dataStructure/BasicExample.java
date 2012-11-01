package dataStructure;

/**
 * This is what the example should look like
 */
public class BasicExample implements IExample {
/**
 * header information of the example
 */
	private ExampleHeader header;
/**
 * the content information of the example
 */
	private ExampleContent content;
/**
 * the properties of the example
 */
	private ExampleProperties properties;
/**
 * get the header data from the example
 * @return IHeader header information
 */
	public IHeader getHeader() 
	{
		return this.header;
	}
/**
 * get the content of the example
 * @return IContent the content of example
 */
	public IContent getContent() 
	{
		return this.content;
	}
/**
 * get the properties from the example
 * @return IProperties properties of example
 */
	public IProperties getProperties() 
	{
		return this.properties;
	}
/**
 * set up the header information for the example
 * @param IHeader
 */
	public void setHeader(IHeader inHeader)
	{
		//we should have conversion...maybe
		//I know we'll pass the right type so I'll just type cast, for now
		this.header = (ExampleHeader) inHeader;
	}
/**
 * set up the content for the example
 * @param IContent
 */
	public void setContent(IContent inContent)
	{
		//we should have conversion...maybe
		//I know we'll pass the right type so I'll just type cast, for now
		this.content = (ExampleContent) inContent;
	}
/**
 * set up the properties for the example
 * @param IProperties
 */
	public void setProperties(IProperties inProperties)
	{
		//we should have conversion...maybe
		//I know we'll pass the right type so I'll just type cast, for now
		this.properties = (ExampleProperties) inProperties;
	}
/**
 * create an example by using the given header, content and properties
 * 
 * @param IHeader inHeader
 * @param IContent inContent
 * @param IProperites inProperties
 * @return BasicExample
 */
	public static BasicExample makeBasicExample(IHeader inHeader,IContent inContent,IProperties inProperties)
	{
		BasicExample bx = new BasicExample();
		bx.setHeader(inHeader);
		bx.setContent(inContent);
		bx.setProperties(inProperties);
		return bx;
	}

}