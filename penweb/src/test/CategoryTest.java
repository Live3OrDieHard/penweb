package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataStructure.BasicExample;
import dataStructure.Category;
import database.Db4oDatabase;
import exceptions.DuplicateException;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author tpatikorn
 * @author iprangishvili
 * @author dmulcahy
 * Test Category-related functions
 * Except BasicExample-Category relationship
 * 
 */
public class CategoryTest {
	private Db4oDatabase db;
	
	@Before
	public void setup() {
		db = new Db4oDatabase("CategoryTest.yap");
	}
	
	@Test
	public void testAddCodeExample() {
		Category category = new Category("Test","This is test");
		BasicExample example = new BasicExample();
		
		// Attempt to add the same example twice
		try {
			category.addCodeExample(example);
		} catch (DuplicateException e) {
		}
		try {
			category.addCodeExample(example);
			fail();
		} catch (DuplicateException e) {
			//it's supposed to come here
		}
		
		// The example should have been added only once
		assertEquals(category.getExampleList().size(), 1);
	}
	
	@After
	public void cleanup() {
		db.close();
	}
}
