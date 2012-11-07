package test;

import org.junit.Before;
import org.junit.Test;

import dataStructure.Category;
import database.Db4oDatabase;

import java.util.ArrayList; 


public class CategoryTest {
	private Db4oDatabase db;
	
	@Before
	public void setup() {
		// Connect to test database
		db = new Db4oDatabase("CategoryTest.yap");
	}	
}
