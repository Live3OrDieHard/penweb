package control;

import java.io.IOException;

import database.*;
import dataStructure.*;

public class DesktopGUIController 
{
	static IDatabase db = new Db4oDatabase("db/localDb.yap");
	static DesktopGUIController controller = new DesktopGUIController();
	/**@TODO
	 * there should be an interface for this.............
	 */
	static IUserInterface  ui;

	/**
	 * when start running, type 
	 * 1 in the console for UserInterfaceCopied
	 * 2 in the console for UserInterfaceCopied2 (no properties panel, a big '2' is there instead
	 */
	public static void main(String args[]) throws IOException
	{
		System.out.println("Please type 1 in the console for MockUI1, anything else for MockUI2");
		int i = System.in.read();
		if(i=='1')
		{
			ui =  new MockUI1(controller);
		}
		else
		{
			ui =  new MockUI2(controller);
		}
		ui.show();
	}
	
	void addBasicExample()
	{
		ExampleHeader h = (ExampleHeader) ui.getHeader();
		ExampleContent c = (ExampleContent) ui.getContent();
		ExampleProperties p = (ExampleProperties) ui.getProperties();
		BasicExample bx = new BasicExample(h,c,p);
		this.addToDB(bx);
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
}
