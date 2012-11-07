package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataStructure.BasicExample;
import dataStructure.ExampleHeader;
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
		ExampleHeader head = new ExampleHeader("aTitle", "anAuthor");
		BasicExample entry = new BasicExample(head, null, null, null);
		testee.store(entry);
		
		assertEquals(testee.getByHeader(head).get(0), entry);
	}
	
	@Test
	public void testGetByHeaderWithTitleOnly() {
		ExampleHeader head = new ExampleHeader("aTitle", null);
		BasicExample entry = new BasicExample(head, null, null, null);
		testee.store(entry);
		
		assertEquals(testee.getByHeader(head).get(0), entry);
	}
	
	@Test
	public void testGetByHeaderWithAuthorOnly() {
		ExampleHeader head = new ExampleHeader(null, "anAuthor");
		BasicExample entry = new BasicExample(head, null, null, null);
		testee.store(entry);
		
		assertEquals(testee.getByHeader(head).get(0), entry);
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
