package control;

import java.io.IOException;

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
public class DesktopGUIController 
{
	static IDatabase db = new Db4oDatabase("db/MarchTest.yap");
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
		System.out.println("Please type a number in the console\n");
		System.out.println("0 for Anjali's UI\n1 for MockUI1\nanything else for MockUI2");
		int i = System.in.read();
		if(i=='0')
		{
			ui =  new MockUI0(controller);
		}
		else if(i=='1')
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
