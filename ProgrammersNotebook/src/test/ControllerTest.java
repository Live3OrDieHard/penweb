package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.Controller;
import dataStructure.BufferEntry;
import dataStructure.Category;
import database.Db4oDatabase;
import database.IDatabase;

public class ControllerTest {
	private Controller testee;
	private IDatabase db;

	@Before
	public void setup() {
		db = new Db4oDatabase("controllerTest.yap");
		testee = new Controller(db, null);
	}
	
	@Test
	public void testAddBasicExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTitleList() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCategoryException() {
		BufferEntry b = new BufferEntry();
		b.setTitle("Title");
		b.setDescription("Desc");
		testee.addCategory(b);
		
		//TODO: Write test to ensure exception is thrown
		testee.addCategory(b);
	}
	
	@Test
	public void testAddCategorySuccess() {
		BufferEntry b = new BufferEntry();
		b.setTitle("Title");
		b.setDescription("Desc");
		testee.addCategory(b);
		
		Category c = (Category) db.getAllCategory().get(0);
		assertEquals(c.getDescription(), "Desc");
		assertEquals(c.getName(), "Title");
	}

	@After
	public void cleanup() {
		db.close();
	}
}
