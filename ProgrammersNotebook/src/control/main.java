package control;

import java.io.IOException;

import database.Db4oDatabase;
import database.IDatabase;

public class main 
{
	/**
	 * when start running, type 
	 * 1 in the console for UserInterfaceCopied
	 * 2 in the console for UserInterfaceCopied2 (no properties panel, a big '2' is there instead
	 */
	public static void main(String args[]) throws IOException
	{
		IDatabase db = new Db4oDatabase("MarchTest.yap");
		IUserInterface  ui = null;
		Controller controller = new Controller(db,ui);
		/*
		System.out.println("Please type a number in the console\n");
		System.out.println("0 for Anjali's UI\n1 for MockUI1\nanything else for MockUI2");
		int i = System.in.read();
		if(i=='0')
		{
		*/
			ui =  new MockUI0(controller);
		/*}
		else if(i=='1')
		{
			ui =  new MockUI1(controller);
		}
		else
		{
			ui =  new MockUI2(controller);
		}
		*/
		controller.ui = ui;
		ui.init();
		ui.show();
	}
	
}
