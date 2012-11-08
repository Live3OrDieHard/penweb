package database;

//This is a comment to make sure I have commit access

import java.util.ArrayList;
import java.util.List;

import dataStructure.*;

public interface IDatabase {
	public void store(IEntry e);
	public List<IEntry> getAll();
	//public List<IExample> getByHeader(IHeader head); // null is wildcard (this might be an issue, we can change later)
	//public List<IExample> getByHeader(String title, List<IPerson> authors); // null is wildcard (this might be an issue, we can change later)
	public List<IExample> getByHeader(String title, IPerson author); // null is wildcard (this might be an issue, we can change later)
	
 	public List<IExample> getByKeyword(String key); // This could be a cool function to implement (match by keyword in body or title)
	// More "getBy" functions to come based on metadata choices
	public void delete(IEntry e);
	public void close(); // Close the connection
	/**
	 * @return
	 */
	public List<IExample> getAllExample();
	
	/**
	 * 
	 * @param name
	 * @return true if the name given is already taken by another category
	 * false otherwise 
	 */
	public boolean isNameRepeat (String name);
	
	/**
	 * 
	 */
	
	public ArrayList<String> listCategoryNames ();
	List<ICategory> getAllCategory();
	
	public IEntry getByID(Long id);
	
	public Long getNewId();
}