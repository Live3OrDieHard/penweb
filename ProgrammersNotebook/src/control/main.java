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
		IDatabase db = new Db4oDatabase("tempDB.yap");
		IUserInterface  ui = null;
		Controller controller = new Controller(db,ui);
		ui =  new DesktopUI(controller);
		controller.ui = ui;
		ui.init();
		ui.show();
	}
	
}
