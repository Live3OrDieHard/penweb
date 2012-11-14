package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import penweb.WebController;

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
		for(long i=0;i<=length/1024;i++)
		{
			int byteread = in.read(buf);
			out.write(buf,0,byteread);
		}
		
		f1.delete();
		
		testee = new WebController();

	}

	@Test
	public void TwoUsernamesTest() {
		//User Alice = new User("Alice","AliceAndBob","R4B8!t");
		//User Bob = new User("Bob1563","AliceAndBob","W0nD3R");
		boolean add1 = testee.addUser("AliceAndBob", "R4B8!t", "Alice");
		boolean add2 = testee.addUser("AliceAndBob", "W0nD3R", "Bob");
		
		assertTrue(!add1&&!add2);

		testee.close();
		db = new Db4oDatabase("webDb4.yap");
		
		assertEquals(db.getAllUsers().size(),1);
		assertEquals(db.getAllUsers().get(0).getDisplayName(),"Alice");
		
		db.close();		
		testee = new WebController();
		
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
		for(long i=0;i<=length/1024;i++)
		{
			int byteread = in.read(buf);
			out.write(buf,0,byteread);
		}

	}


}
