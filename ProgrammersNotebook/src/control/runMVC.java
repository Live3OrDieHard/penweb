package control;

import java.io.IOException;

import database.Db4oDatabase;
import database.IDatabase;

public class runMVC 
{
	/**
	 * 
	 */
	public static void main(String args[]) throws IOException
	{
		IDatabase db = new Db4oDatabase("tempDB.yap");
		IUserInterface  ui = null;
		Controller controller = new Controller(db,ui);
		ui =  new DesktopUI(controller);
		//ui =  new NewDesktopUI2(controller);
		controller.ui = ui;
		ui.init();
		ui.show();
	}
}
