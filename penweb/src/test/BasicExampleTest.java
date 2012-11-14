package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dataStructure.BasicExample;
import dataStructure.BufferEntry;
import dataStructure.Category;
import dataStructure.NonUser;
import dataStructure.User;
import exceptions.DuplicateException;
import dataStructure.User;

/**
 * @author tpatikorn
 * @author iprangishvili
 * @author dmulcahy 
 * Test functions in BasicExample and BasicExample-related functions
 * except those involve BasicExample-Category relationship
 */
public class BasicExampleTest {

	@Before
	public void setup() {
	}

	@Test
	public void testTransferFromEntry() {
		BufferEntry buf = new BufferEntry();
		buf.setLanguage("Java");
		buf.setTitle("something");
		buf.setCode("Hello World");
		buf.setSource("");

		BasicExample example = new BasicExample();
		example.transferFromBuffer(buf);

		assertEquals(example.getCode(),"Hello World");
		assertEquals(example.getTitle(),"something");
		assertEquals(example.getLanguage(),"Java");
		assertEquals(example.getSource(),"");
	}

	@Test
	public void testAssignId() {
		BasicExample example = new BasicExample();
		int returncode = example.assignId(42L);
		assertTrue(example.getId().equals(42L));
		assertEquals(returncode,0);
		returncode = example.assignId(43524859235723L);
		assertTrue(example.getId().equals(42L));
		assertEquals(returncode,1);
	}

	@Test
	public void testAssignOwner() {
		BasicExample example = new BasicExample();
		User Alice = new User("Alice", null, null);
		User Bob = new User("Bob", null, null);
		
		int returncode = example.assignOwner(Alice);
		assertEquals(example.getOwner(),Alice);
		assertEquals(returncode,0);
		returncode = example.assignOwner(Bob);
		assertEquals(example.getOwner(),Alice);
		assertEquals(returncode,1);


	}

}
