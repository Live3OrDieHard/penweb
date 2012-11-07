package dataStructure;

import java.util.ArrayList;
import java.util.List;

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
	private Long codeId;
	private IPerson owner;
	
	public BasicExample(ExampleHeader h, ExampleContent c, ExampleProperties p, IPerson owner) 
	{
		this.header = h;
		this.content = c;
		this.properties = p;
		this.codeId = (long)(Math.random() * 1000000);
		this.owner = owner;
	}

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
	 * @see dataStructure.IEntry#getId()
	 */
	@Override
	public Long getEntryId() {
		return codeId;
	}

	/**
	 * @see dataStructure.IEntry#getOwnerId()
	 */
	@Override
	public Long getOwnerId() {
		return owner.getId();
	}
}
