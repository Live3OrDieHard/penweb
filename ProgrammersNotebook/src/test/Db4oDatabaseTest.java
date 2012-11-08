package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataStructure.BasicExample;
import dataStructure.ExampleHeader;
import dataStructure.IEntry;
import dataStructure.IExample;
import dataStructure.NonUser;
import database.Db4oDatabase;

public class Db4oDatabaseTest {
	private Db4oDatabase testee;
	private String databaseName = "db4otest.yap";

	@Before
	public void setup() {
		// Connect to test database
		testee = new Db4oDatabase(databaseName);
	}

	@Test
	public void testGetByHeaderWithTitleAndAuthor() {
		BasicExample entry = new BasicExample();
		NonUser u = new NonUser("anAuthor");
		entry.setTitle("aTitle");
		entry.assignOwner(u);
		testee.store(entry);

		assertEquals(testee.getByHeader("aTitle", u).get(0).getTitle(),
				entry.getTitle());
	}

	@Test
	public void testGetByHeaderWithTitleOnly() {
		BasicExample entry = new BasicExample();
		entry.setTitle("aTitle");
		testee.store(entry);

		assertEquals(testee.getByHeader("aTitle", null).get(0).getTitle(),
				entry.getTitle());
	}

	@Test
	public void testGetByHeaderWithAuthorOnly() {
		BasicExample entry = new BasicExample();
		NonUser u = new NonUser("anAuthor");
		entry.assignOwner(u);
		testee.store(entry);
		String name = testee.getByHeader(null, u).get(0).getOwner().getName();
		assertEquals(name, entry.getOwner().getName());
	}

	@Test
	public void testGetByKeyword() {
		// TODO: Implement when the actual function is implemented
	}

	@Test
	public void testedit() {
		BasicExample entry = new BasicExample();
		entry.setCode("haha");
		entry.setTitle("title");
		entry.setDescription(null);
		testee.store(entry);

		entry.setDescription("itworks!");

		BasicExample entry2 = new BasicExample();

		List<IExample> list = testee.getByHeader("title", null);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof BasicExample) {
				entry2 = (BasicExample) list.get(i);
				break;
			}
		}
		
		assertEquals(entry2.getDescription().equals("itworks!"), true);
	}
	
	@After
	public void cleanup() throws IOException {
		testee.close();

		//Delete the database. We don't need it anymore.
		File f = new File(databaseName);
		if (f.exists())
			f.delete();
	}
}
