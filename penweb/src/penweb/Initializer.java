package penweb;

import javax.servlet.ServletContextEvent;

import com.db4o.ObjectServer;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ServerConfiguration;

/**
 * Initialization class for the Tomcat server which will start the 
 * db4o server.
 * @author Justin Chines
 */
public class Initializer implements javax.servlet.ServletContextListener {
	public static ObjectServer db4oServer;
	private static String databaseName = "penweb3.yap";
	
	/**
	 * Runs when the Tomcat server starts. Starts the db4o server
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServerConfiguration config = Db4oClientServer.newServerConfiguration();
		config.common().updateDepth(10);
		config.common().activationDepth(10);
		
		db4oServer = Db4oClientServer.openServer(config, databaseName, 0);
	}

	/**
	 * Runs when the Tomcat server ends.
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		db4oServer.close();		
	}
	
	public static String getDatabaseName() {
		return databaseName;
	}
}