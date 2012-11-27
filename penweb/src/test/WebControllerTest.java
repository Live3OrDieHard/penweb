package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import penweb.WebController;

import dataStructure.ICategory;
import dataStructure.IExample;
import dataStructure.IUser;
import database.Db4oDatabase;

import penweb.Initializer;

public class WebControllerTest {
	private WebController testee;
	private Db4oDatabase db;
	private String databaseName = "webConTest.yap";

	@Before
	public void setup() throws IOException {
		testee = new WebController(databaseName);
	}

	@Test
	public void TwoUsernamesTest() {
		
		boolean add1 = testee.addUser("AliceAndBob", "R4B8!t", "Alice");
		boolean add2 = testee.addUser("AliceAndBob", "W0nD3R", "Bob");

		assertTrue(add1);
		assertFalse(add2);

		testee.close();
		db = new Db4oDatabase(databaseName,true);

		assertEquals(db.getAllUsers().size(), 1);
		assertEquals(db.getAllUsers().get(0).getDisplayName(), "Alice");

		db.close();
		testee = new WebController(databaseName);
	}

	@Test
	public void addCategoryTest() {
		testee.addCategory("Alice's", "This is Alice's");
		testee.addCategory("Bob's", "This is Bob's");

		List<ICategory> categories = testee.getCategories();

		assertEquals(categories.size(), 2);
		assertTrue(categories.get(0).getTitle().equals("Alice's")
				|| categories.get(1).getTitle().equals("Alice's"));
		assertTrue(categories.get(0).getTitle().equals("Bob's")
				|| categories.get(1).getTitle().equals("Bob's"));
		assertTrue(categories.get(0).getDescription().equals("This is Alice's")
				|| categories.get(1).getDescription().equals("This is Alice's"));
		assertTrue(categories.get(0).getDescription().equals("This is Bob's")
				|| categories.get(1).getDescription().equals("This is Bob's"));
	}

	@Test
	public void addCategoryTest2() {
		testee.addUser("Alice", "Alice123", "I'm not Alice");
		IUser Alice = testee.getUserByLoginName("Alice");
		testee.addUser("Bob", "Bob123", "I'm Bob");
		IUser Bob = testee.getUserByLoginName("Bob");
		testee.addCategory("Alice's", "This is Alice's",Alice,true);
		testee.addCategory("Bob's", "This is Bob's",Bob,false);
		
		List<ICategory> categories = testee.getCategories();

		assertEquals(categories.size(), 2);
		ICategory cat0 = null;
		ICategory cat1 = null;
		for(ICategory cat: categories)
		{
			if(cat.getTitle().equals("Alice's"))
				cat0 = cat;
			if(cat.getTitle().equals("Bob's"))
				cat1 = cat;
			Alice.getOwnedCategoryList();
		}

		assertTrue(cat0.isPublic());
		assertEquals(cat0.getOwner(),Alice);
			
		assertFalse(cat1.isPublic());
		assertEquals(cat1.getOwner(),Bob);
	}

	@Test
	public void getCategoryByIdTest() {
		testee.addCategory("Alice's", "This is Alice's");
		testee.addCategory("Bob's", "This is Bob's");

		List<ICategory> categories = testee.getCategories();
		ICategory c1 = categories.get(0);
		ICategory c2 = categories.get(1);

		assertEquals(categories.size(), 2);
		assertTrue(c1.getTitle().equals("Alice's")
				|| c2.getTitle().equals("Alice's"));
		assertTrue(c1.getTitle().equals("Bob's")
				|| c2.getTitle().equals("Bob's"));
		assertTrue(c1.getDescription().equals("This is Alice's")
				|| c2.getDescription().equals("This is Alice's"));
		assertTrue(c1.getDescription().equals("This is Bob's")
				|| c2.getDescription().equals("This is Bob's"));
	}

	@Test
	public void addCodeTest() {
		testee.addCode("AliceAndBob", "R4B8!t", "Alice", null);
		testee.addCode("AliceAndBob", "W0nD3R", "Bob", null);

		List<IExample> examples = testee.getExamples();
		assertEquals(examples.size(), 2);
		assertTrue(examples.get(0).getCode().equals("R4B8!t")
				|| examples.get(1).getCode().equals("R4B8!t"));
		assertTrue(examples.get(0).getLanguage().equals("Alice")
				|| examples.get(1).getLanguage().equals("Alice"));
	}

	@Test
	public void getCodeByIdTest() {
		testee.addCode("AliceAndBob", "R4B8!t", "Alice", null);
		testee.addCode("AliceAndBob", "W0nD3R", "Bob", null);

		List<IExample> examples = testee.getExamples();
		assertEquals(examples.size(), 2);
		long id1 = examples.get(0).getId();
		long id2 = examples.get(1).getId();

		IExample e1 = testee.getExampleById(id1);
		IExample e2 = testee.getExampleById(id2);

		assertEquals(e1.getTitle(), "AliceAndBob");
		assertEquals(e2.getTitle(), "AliceAndBob");
		assertTrue(e1.getCode().equals("R4B8!t")
				|| e2.getCode().equals("R4B8!t"));
		assertTrue(e1.getCode().equals("W0nD3R")
				|| e2.getCode().equals("W0nD3R"));
		assertTrue(e1.getLanguage().equals("Alice")
				|| e2.getLanguage().equals("Alice"));
		assertTrue(e1.getLanguage().equals("Bob")
				|| e2.getLanguage().equals("Bob"));
	}

	@Test
	public void getCateogoryByIdTest() {
		testee.addUser("Alice", "Alice123", "I'm not Alice");
		IUser Alice = testee.getUserByLoginName("Alice");
		Long newId = testee.addCategory("Alice's", "This is Alice's",Alice,true);
		
		assertEquals(testee.getCategories().size(),1);
		
		assertEquals(testee.getCategoryById(newId),testee.getCategories().get(0));
		assertEquals(testee.getCategoryById(newId).getOwner(),Alice);
		
	}
	
	@After
	public void cleanup() throws IOException {
		testee.close();
		
		File f1 = new File(databaseName);
		if(f1.exists())
			f1.delete();

	}

}
