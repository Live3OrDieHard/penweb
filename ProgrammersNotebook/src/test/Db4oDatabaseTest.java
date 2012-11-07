package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataStructure.BasicExample;
import dataStructure.ExampleHeader;
import dataStructure.NonUser;
import database.Db4oDatabase;

public class Db4oDatabaseTest {
	private Db4oDatabase testee;
	
	@Before
	public void setup() {
		// Connect to test database
		testee = new Db4oDatabase("test.yap");
	}

	@Test
	public void testGetByHeaderWithTitleAndAuthor() {
		BasicExample entry = new BasicExample();
		NonUser u = new NonUser("anAuthor");
		entry.setTitle("aTitle");
		entry.assignOwner(u);
		testee.store(entry);
		
		assertEquals(testee.getByHeader("aTitle",u).get(0).getTitle(), entry.getTitle());
	}
	
	@Test
	public void testGetByHeaderWithTitleOnly() {
		BasicExample entry = new BasicExample();
		entry.setTitle("aTitle");
		testee.store(entry);

		assertEquals(testee.getByHeader("aTitle",null).get(0).getTitle(), entry.getTitle());
	}
	
	@Test
	public void testGetByHeaderWithAuthorOnly() {
		BasicExample entry = new BasicExample();
		NonUser u = new NonUser("anAuthor");
		entry.assignOwner(u);
		testee.store(entry);
		String name = testee.getByHeader(null,u).get(0).getOwner().getName();
		assertEquals(name, entry.getOwner().getName());
	}

	@Test
	public void testGetByKeyword() {
		//TODO: Implement when the actual function is implemented
	}
	
	@After
	public void cleanup() {
		testee.close();
	}

}
