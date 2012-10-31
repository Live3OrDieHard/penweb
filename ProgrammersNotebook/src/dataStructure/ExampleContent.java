package dataStructure;

public class ExampleContent implements IContent
{
	private String code;
	
	public String getCode()
	{
		return this.code;
	}
	
	public void setCode(String code)
	{
		this.code = code;
	}
	
	public ExampleContent(String code)
	{
		this.code = code;
	}
}
