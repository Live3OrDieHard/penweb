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
		db = new Db4oDatabase("UserTest.yap");
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
		/*
		 * ///// not yet implemented /////
		 * try to change password
		 * User user = new User()
		 * user.setPassword(newPassword) <<< shouldn't be allowed
		 * should be changePassword(oldPassword, newPassword) or something
		 */
	}
	
	@After
	public void cleanup() {
		db.close();
	}
}
