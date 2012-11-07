package control;

import java.io.IOException;
import java.util.LinkedList;
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

	void addBasicExample()
	{
		ExampleHeader h = (ExampleHeader) ui.getHeader();
		ExampleContent c = (ExampleContent) ui.getContent();
		ExampleProperties p = (ExampleProperties) ui.getProperties();
		if((h!=null)&&(c!=null)&&(p!=null))
		{
			BasicExample bx = new BasicExample(h,c,p);
			this.addToDB(bx);
		}
	}
	
	void addEssay()
	{
		ExampleHeader h = (ExampleHeader) ui.getHeader();
		ExampleContent c = (ExampleContent) ui.getContent();
		MockEntry es = new MockEntry(h,c);
		this.addToDB(es);
	}
	
	private void addToDB(IEntry e) 
	{
		db.store(e);
	}

	public List<IEntry> getAllinDB() {
		return db.getAll();
	}

	public List<IHeader> getHeaderList() 
	{
		List<IEntry> listE = db.getAll();
		List<IHeader> listH = new LinkedList<IHeader>();
		for(int i=0;i<listE.size();i++)
		{
			listH.add(listE.get(i).getHeader());
		}
		return listH;
	}

	public void close() {
		db.close();
		
	}
}
