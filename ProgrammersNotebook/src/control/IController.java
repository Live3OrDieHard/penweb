package control;

import java.util.List;

import dataStructure.*;
import exceptions.CannotAddToDbException;
import exceptions.PENException;

public interface IController 
{
	public BasicExample addBasicExample(BufferEntry buf) throws PENException;
	public void addCategory(BufferEntry buf) throws PENException;
	public void close();
	List<IExample> getAllExampleinDB();
	List<ICategory> getAllCategoryinDB();
}
