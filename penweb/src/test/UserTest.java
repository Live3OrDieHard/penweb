package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataStructure.User;
import database.Db4oDatabase;

/**
 * @author tpatikorn
 * @author iprangishvili
 * @author dmulcahy 
 * Test user-related functions
 */
public class UserTest {
	private Db4oDatabase db;
	
	@Before
	public void setup() {
		db = new Db4oDatabase("UserTest.yap",true);
	}
	
	@Test
	public void testUserHasId() {
		User Alice = new User("Alice","WonderLandAlice","R4B8!t");
		db.store(Alice);
		Alice.assignId(4L);
	}

	@Test
	public void testUserPreAssignId() {
		User Alice = new User("Alice","WonderLandAlice","R4B8!t");
		Alice.assignId(4L);
		db.store(Alice);
		assertTrue(Alice.getId().equals(4L));
	}

	@Test
	public void TwoUsersIdTest() {
		User Alice = new User("Alice","WonderLandAlice","R4B8!t");
		User Bob = new User("Bobby","WonderProductsBob","W0nD3R");
		db.store(Alice);
		db.store(Bob);
		assertTrue(!Alice.getId().equals(Bob.getId()));
	}
	
	@Test
	public void changePasswordTest() {
		User Alice = new User("Alice","123","R4B8!t");
		assertTrue(Alice.checkPassword("123"));
		Alice.changePassword("123", "1111", "1111");
		assertTrue(Alice.checkPassword("1111"));
		Alice.changePassword("123", "122452", "122452");
		assertFalse(Alice.checkPassword("122452"));
		assertTrue(Alice.checkPassword("1111"));
		Alice.changePassword("1111", "1212", "2222");
		assertFalse(Alice.checkPassword("1212"));
		
	}
	
	@Test
	public void equalsTest(){
		User Alice = new User("Alice","WonderLandAlice","R4B8!t");
		User Bob = new User("Bobby","WonderProductsBob","W0nD3R");
		User John = new User("John","J","Johnny");
		Long newId = 327236L; 
		Alice.assignId(123L);
		Bob.assignId(2314L);
		John.assignId(123L);
		assertTrue(Alice.equals(John));
		assertFalse(Alice.equals(Bob));
		assertFalse(Alice.equals(newId));
		
	}
	
	@After
	public void cleanup() {
		db.close();
	}
}
