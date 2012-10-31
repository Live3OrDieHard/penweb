package pnotebook;

import java.util.List;

import dataStructure.*;

public interface IDatabase {
	public void store(IEntry e);
	public List<IEntry> getAll();
	public List<IEntry> getByHeader(IHeader head); // null is wildcard (this might be an issue, we can change later)
 	public List<IEntry> getByKeyword(String key); // This could be a cool function to implement (match by keyword in body or title)
	// More "getBy" functions to come based on metadata choices
}
