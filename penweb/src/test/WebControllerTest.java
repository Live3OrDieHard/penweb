package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import penweb.WebController;

import dataStructure.BasicExample;
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
	public void addCodeTest2() {
		testee.addUser("Alice", "Alice123", "I'm not Alice");
		IUser Alice = testee.getUserByLoginName("Alice");
		testee.addUser("Bob", "Bob123", "I'm Bob");
		IUser Bob = testee.getUserByLoginName("Bob");
		
		Long id1 = testee.addCode("AliceAndBob", "R4B8!t", "Java", "Alice",true);
		Long id2 = testee.addCode("AliceAndBob", "W0nD3R", "C", "Bob",false);

		List<IExample> examples = testee.getExamples();
		IExample ex0 = null;
		IExample ex1 = null;
		for(IExample ex: examples)
		{
			if(ex.getOwner().equals(Alice))
				ex0 = ex;
			if(ex.getOwner().equals(Bob))
				ex1 = ex;
		}
		assertTrue(ex0.isPublic());
		assertFalse(ex1.isPublic());
		assertEquals(ex0.getCode(),"R4B8!t");
		assertEquals(ex1.getCode(),"W0nD3R");

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
	
	@Test
	public void getTitlesTest() {
		testee.addCode("AliceAndBob", "R4B8!t", "Alice", null);
		testee.addCode("AliceAndBob", "W0nD3R", "Bob", null, true);
		
		assertEquals(testee.getTitles().get(0),"AliceAndBob");
		assertEquals(testee.getTitles().get(1),"AliceAndBob");
		assertEquals(testee.getTitles().size(),2);
	}

	@Test
	public void getNumEntriesTest() {
		testee.addCode("AliceAndBob", "R4B8!t", "Alice", null);
		testee.addCode("AliceAndBob", "W0nD3R", "Bob", null, true);
		testee.addCode("AliceAndBob", "R4B8!t", "Alice", null);
		testee.addCode("AliceAndBob", "W0nD3R", "Bob", null, true);
		testee.addCode("AliceAndBob", "R4B8!t", "Alice", null);
		testee.addCode("AliceAndBob", "W0nD3R", "Bob", null, true);
		testee.addCode("AliceAndBob", "R4B8!t", "Alice", null);
		testee.addCode("AliceAndBob", "W0nD3R", "Bob", null, true);
		testee.addCode("AliceAndBob", "R4B8!t", "Alice", null);
		testee.addCode("AliceAndBob", "W0nD3R", "Bob", null, true);
		testee.store(new BasicExample());
		
		assertEquals(testee.getNumEntries(),11);
	}

	
	@Test
	public void tryLoginTest() {
		assertFalse(testee.tryLogin("name", "password"));
		
		testee.addUser("name", "password", "displayName");
		
		assertTrue(testee.tryLogin("name", "password"));

		assertFalse(testee.tryLogin("name", "password2"));
		
	}
	
	@Test
	public void isCateogoryTitleTakenTest() {
		assertFalse(testee.isCategoryTitleTaken("title"));
		testee.addCategory("title", "desc", null, true);
		assertTrue(testee.isCategoryTitleTaken("title"));
	}
	
	@Test
	public void getCodeByLanguageAndUserTest() {
		testee.addUser("4chaner", "12345", "4chaner");
		testee.addUser("Iva", "password", "Iva");
		testee.addCode("Sleep Sort", "I'm a genius", "C++", "4chaner",true);
		Long id1 = testee.addCode("Sleep Sort", "System.out.printf();", "Java", "4chaner",false);
		Long id2 = testee.addCode("Sleep Sort in Java", "I'm a genius", "Java", "4chaner",true);
		Long id3 = testee.addCode("Merge Sort","This is Merge Sort", "Java", "Iva", true);
		testee.addCode("simple loop", "while(1){}", "C", "Iva",  false);
		Long id4 = testee.addCode("simple loop", "while(true){}", "Java", "Iva",  false);
		
		BasicExample ex2 = new BasicExample();
		ex2.assignId(id2);
		BasicExample ex3 = new BasicExample();
		ex3.assignId(id3);
		BasicExample ex4 = new BasicExample();
		ex4.assignId(id4);
		
		List<IExample> list = new ArrayList<IExample>();
		list.add(ex2);
		list.add(ex3);
		list.add(ex4);
		
		List<IExample> listExamples = testee.getCodeByLanguageAndUser(
				testee.getUserByLoginName("Iva"), "Java");
		assertEquals(listExamples.size(),3);
		assertEquals(listExamples.get(0).getLanguage(),"Java");
		assertEquals(listExamples.get(1).getLanguage(),"Java");
		assertEquals(listExamples.get(2).getLanguage(),"Java");
		/* abuse .equals() for testing */
		assertTrue(listExamples.containsAll(list));
		assertTrue(list.containsAll(listExamples));
	}
	
	@Test
	public void getAllPublicExamplesTest() {
		testee.addUser("4chaner", "12345", "4chaner");
		testee.addUser("Iva", "password", "Iva");
		Long id1 = testee.addCode("Sleep Sort", "I'm a genius", "C++", "4chaner",true);
		Long id2 = testee.addCode("Sleep Sort", "System.out.printf();", "Java", "4chaner",false);
		Long id3 = testee.addCode("Sleep Sort in Java", "I'm a genius", "Java", "4chaner",true);
		Long id4 = testee.addCode("Merge Sort","This is Merge Sort", "Java", "Iva", true);
		Long id5 = testee.addCode("simple loop", "while(1){}", "C", "Iva",  false);
		Long id6 = testee.addCode("simple loop", "while(true){}", "Java", "Iva",  false);

		BasicExample ex1 = new BasicExample();
		ex1.assignId(id1);
		BasicExample ex3 = new BasicExample();
		ex3.assignId(id3);
		BasicExample ex4 = new BasicExample();
		ex4.assignId(id4);
		
		List<IExample> list = new ArrayList<IExample>();
		list.add(ex1);
		list.add(ex3);
		list.add(ex4);
		
		List<IExample> listExamples = testee.getAllPublicExamples();
		assertTrue(listExamples.containsAll(list));
		assertTrue(list.containsAll(listExamples));
	}
	
	@Test
	public void getDependerOfTest() {
		testee.addUser("4chaner", "12345", "4chaner");
		testee.addUser("Iva", "password", "Iva");
		Long id1 = testee.addCode("Sleep Sort", "I'm a genius", "C++", "4chaner",true);
		Long id2 = testee.addCode("Sleep Sort", "System.out.printf();", "Java", "4chaner",false);
		Long id3 = testee.addCode("Sleep Sort in Java", "I'm a genius", "Java", "4chaner",true);
		Long id4 = testee.addCode("Merge Sort","This is Merge Sort", "Java", "Iva", true);
		Long id5 = testee.addCode("simple loop", "while(1){}", "C", "Iva",  false);
		Long id6 = testee.addCode("simple loop", "while(true){}", "Java", "Iva",  false);
		IExample ex1 = testee.getExampleById(id1);
		IExample ex2 = testee.getExampleById(id2);
		IExample ex4 = testee.getExampleById(id4);
		IExample ex6 = testee.getExampleById(id6);
		
		ex1.addDependency(ex2);
		ex2.addDependency(ex6);
		ex4.addDependency(ex6);
		
		testee.store(ex1);
		testee.store(ex2);
		testee.store(ex4);
		testee.store(ex6);
		
		assertEquals(testee.getDependerOf(ex1).size(),0);
		assertEquals(testee.getDependerOf(ex2).size(),1);
		assertEquals(testee.getDependerOf(ex6).size(),3);
		assertEquals(testee.getDependerOf(ex4).size(),0);
	}
	
	@After
	public void cleanup() throws IOException {
		testee.close();
		
		File f1 = new File(databaseName);
		if(f1.exists())
			f1.delete();

	}

}
