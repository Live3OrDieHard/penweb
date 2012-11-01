package control;

import dataStructure.*;

/**
 * 
 * @author Thanaporn
 * random class to help illustrate how controller works
 */
public class MockEntry implements IEntry
{
	private ExampleHeader header;
	private ExampleContent content;
	
	public MockEntry(ExampleHeader h, ExampleContent c) 
	{
		this.header = h;
		this.content = c;
	}

	public IHeader getHeader() 
	{
		return this.header;
	}

	public IContent getContent() 
	{
		return this.content;
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
	

}
