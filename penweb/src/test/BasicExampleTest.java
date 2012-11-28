/*******************************************************************************
 * Copyright (c) 2012 Team 3: Live Three or Die Hard
 * 
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Team 3
 *******************************************************************************/

package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import dataStructure.BasicExample;
import dataStructure.BufferEntry;
import dataStructure.Category;
import dataStructure.IUser;
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
		buf.setLanguage("java");
		buf.setTitle("something");
		buf.setCode("Hello World");
		buf.setSource("");

		BasicExample example = new BasicExample();
		example.transferFromBuffer(buf);

		assertEquals(example.getCode(),"Hello World");
		assertEquals(example.getTitle(),"something");
		assertEquals(example.getLanguage(),"java");
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
	
	@Test
	public void testGetAuthorsNames() {
		BasicExample example = new BasicExample();
		ArrayList<IUser> authors = new ArrayList<IUser>();
		authors.add(new User(null, null, "Alice"));
		authors.add(new User(null, null, "Bob"  ));
		
		example.setAuthors(authors);
		assertEquals("Alice, Bob", example.getAuthorsNames());
	}

	@Test
	public void getAuthorNamesTest() {
		BasicExample example = new BasicExample();
		User Alice = new User("Alice", null, "Alice");
		User Bob = new User("Bob", null, "Bob");
		ArrayList<IUser> users = new ArrayList<IUser>();
		users.add(Alice);
		users.add(Bob);
		example.setAuthors(users);
		assertEquals(example.getAuthorsNames(),"Alice, Bob");
	}
	
	@Test
	public void dependencyTest() {
		BasicExample child = new BasicExample();
		BasicExample parent = new BasicExample();
		parent.setTitle("parent");
		child.addDependency(parent);
		
		assertEquals(child.getDependency().size(),1);
		assertEquals(child.getDependency().get(0).getTitle(),"parent");

	}
}
