package dataStructure;

/**
 * 
 * @author Thanaporn
 * for non-user people involved
 * e.g. authors that are not users
 */
public class NonUser implements IPerson
{
	/**
	 * the name of the NonUser
	 */
	private String name;
	//might want this later
	//int refNumber;
	/*
	 * default constructor for the NonUser class
	 */
	public NonUser(String name) 
	{
		this.name = name;
	}
	/**
	 * get the name of the NonUser
	 * @return String name
	 */
	public String getName()
	{
		return this.name;
	}
	/* (non-Javadoc)
	 * @see dataStructure.IPerson#getId()
	 */
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
