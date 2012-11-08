package test;

import org.junit.Before;

import database.Db4oDatabase;



public class CategoryTest {
	private Db4oDatabase db;
	
	@Before
	public void setup() {
		// Connect to test database
		db = new Db4oDatabase("CategoryTest.yap");
	}	
}
