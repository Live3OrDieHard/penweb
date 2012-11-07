package control;

import java.util.ArrayList;
import java.util.List;

import database.*;
import dataStructure.*;

/**
 * 
 * @author Thanaporn
 * can run (sort of) MockUI0 (anjali) and MockUI1 and MockUI2 (Chrissy)
 * retrieve function is not included in the controller (yet)
 * MockUI0 has a prototype of retrieve function
 * see MockUI0 for more info
 */
public class Controller 
{
	IDatabase db;
	IUserInterface  ui;
	
	public Controller(IDatabase db, IUserInterface ui) {
		this.db = db;
		this.ui = ui;
	}

	void addBasicExample(BufferEntry buf)
	{
		/*
		ExampleHeader h = (ExampleHeader) ui.getHeader();
		ExampleContent c = (ExampleContent) ui.getContent();
		*/
		BasicExample e = new BasicExample();
		e.setTitle(buf.getTitle());
		e.setCode(buf.getCode());
		e.setAuthors(buf.getAuthors());
		ExampleProperties prop = new ExampleProperties();
		prop.setLanguage(buf.getLanguage());
		prop.setSource(buf.getSource());
		e.setProperties(prop);
		this.addToDB(e);
	}
	
	public void addToDB(IEntry e) 
	{
		db.store(e);
	}

	public List<IEntry> getAllinDB() {
		return db.getAll();
	}
	
	public List<String> getTitleList() 
	{
		List<IExample> listE = db.getAllExample();
		List<String> listH = new ArrayList<String>();
		for(int i=0;i<listE.size();i++)
		{
			listH.add(listE.get(i).getTitle());
		}
		return listH;
	}
	
	public void close() {
		db.close();
		
	}
}