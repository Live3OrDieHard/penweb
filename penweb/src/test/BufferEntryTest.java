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

import org.junit.Test;

import dataStructure.BufferEntry;
import dataStructure.Category;
import dataStructure.NonUser;
import dataStructure.User;

/**
 * @author tpatikorn
 * @author iprangishvili
 * @author dmulcahy 
 * Test BufferEntry
 */
public class BufferEntryTest {

	@Test
	public void testAddCategory() {
		BufferEntry entry = new BufferEntry();
		Category category1 = new Category("Team3", "We're awesome");
		Category category2 = new Category("Team3 again", "We're awesome again");

		assertEquals(entry.getCategories().size(),0);
		
		entry.addCategory(category1);

		assertEquals(entry.getCategories().size(),1);
		assertTrue(entry.getCategories().contains(category1));
		
		entry.addCategory(category2);

		assertEquals(entry.getCategories().size(),2);
		assertTrue(entry.getCategories().contains(category2));
		
	}

	@Test
	public void testAddAuthor() {
		BufferEntry entry = new BufferEntry();
		User Alice = new User("Alice", null, null);
		User Bob = new User("Bob", null, null);
		
		assertEquals(entry.getAuthors().size(),0);

		entry.addAuthor(Alice);
		
		assertEquals(entry.getAuthors().size(),1);
		assertEquals(entry.getAuthors().get(0),Alice);
		
		entry.addAuthor(Bob);
		
		assertEquals(entry.getAuthors().size(),2);
		assertTrue(entry.getAuthors().contains(Alice));
		assertTrue(entry.getAuthors().contains(Bob));
		
	}

}
