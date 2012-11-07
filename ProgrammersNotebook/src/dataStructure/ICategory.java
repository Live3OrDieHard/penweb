package dataStructure;

public interface ICategory extends IEntry{
	String getName();
	void setName(String name);
	
	IPerson getOwner();
	
	String getDescription();
	void setDescription(String description);
}
