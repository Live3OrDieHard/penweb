/*******************************************************************************
 * Copyright (c) 2012 Team 3: Live Three or Die Hard
 * 
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Team 3
 *******************************************************************************/

package dataStructure;

/**
 * @author tpatikorn
 * The ExampleContent class contains the code
 * of the examples and allows the user to access
 * and edit code.
 * ***No longer used***
 */
public class ExampleContent implements IContent
{
	/**
	 * Code in the example.
	 */
	private String code;
	
	/**
	 * Getter function to get code from the example
	 * @return String
	 */
	public String getCode()
	{
		return this.code;
	}
	
	/**
	 * Set up the code to the example
	 * @param code
	 */
	public void setCode(String code)
	{
		this.code = code;
	}
	
	/**
	 * Default constructor for the ExampleContent class
	 */
	public ExampleContent(String code)
	{
		this.code = code;
	}
}
