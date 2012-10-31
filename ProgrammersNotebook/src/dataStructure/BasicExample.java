package dataStructure;

/**
 * This is what the example should look like
 */
public class BasicExample implements IExample {

	private ExampleHeader header;
	private ExampleContent content;
	private ExampleProperties properties;
	
	public IHeader getHeader() 
	{
		return this.header;
	}

	public IContent getContent() 
	{
		return this.content;
	}

	public IProperties getProperties() 
	{
		return this.properties;
	}
	
	public void setHeader(IHeader inHeader)
	{
		//we should have conversion...maybe
		//I know we'll pass the right type so I'll just type cast, for now
		this.header = (ExampleHeader) inHeader;
	}
	
	public void setContent(IContent inContent)
	{
		//we should have conversion...maybe
		//I know we'll pass the right type so I'll just type cast, for now
		this.content = (ExampleContent) inContent;
	}
	
	public void setProperties(IProperties inProperties)
	{
		//we should have conversion...maybe
		//I know we'll pass the right type so I'll just type cast, for now
		this.properties = (ExampleProperties) inProperties;
	}
	
	public static BasicExample makeBasicExample(IHeader inHeader,IContent inContent,IProperties inProperties)
	{
		BasicExample bx = new BasicExample();
		bx.setHeader(inHeader);
		bx.setContent(inContent);
		bx.setProperties(inProperties);
		return bx;
	}

}
