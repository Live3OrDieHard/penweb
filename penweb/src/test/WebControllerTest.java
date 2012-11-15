package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import dataStructure.User;
import database.Db4oDatabase;

public class WebControllerTest {
	private WebController testee;
	private Db4oDatabase db;

	@Before
	public void setup() throws IOException {
		File f1 = new File("webDb4.yap");
		File f2 = new File("webDb4copy.yap");

		InputStream in = new FileInputStream(f1);
		OutputStream out = new FileOutputStream(f2);

		long length = f1.length();

		byte[] buf = new byte[1024];
		if (length != 0) {
			for (long i = 0; i <= length / 1024; i++) {
				int byteread = in.read(buf);
				out.write(buf, 0, byteread);
			}
		}
		f1.delete();

		testee = new WebController();
	}

	@Test
	public void TwoUsernamesTest() {
		boolean add1 = testee.addUser("AliceAndBob", "R4B8!t", "Alice");
		boolean add2 = testee.addUser("AliceAndBob", "W0nD3R", "Bob");

		assertTrue(add1 && !add2);

		testee.close();
		db = new Db4oDatabase("webDb4.yap");

		assertEquals(db.getAllUsers().size(), 1);
		assertEquals(db.getAllUsers().get(0).getDisplayName(), "Alice");

		db.close();
		testee = new WebController();
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

	@After
	public void cleanup() throws IOException {
		testee.close();

		File f2 = new File("webDb4.yap");
		File f1 = new File("webDb4copy.yap");

		InputStream in = new FileInputStream(f1);
		OutputStream out = new FileOutputStream(f2);

		long length = f1.length();

		byte[] buf = new byte[1024];
		if (length != 0) {
			for (long i = 0; i <= length / 1024; i++) {
				int byteread = in.read(buf);
				out.write(buf, 0, byteread);
			}
		}

	}

}
