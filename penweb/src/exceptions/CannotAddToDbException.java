/*******************************************************************************
 * Copyright (c) 2012 Team 3: Live Three or Die Hard
 * 
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Team 3
 *******************************************************************************/

package exceptions;

/**
 * @author tpatikorn
 * Thrown by anything except user interface classes to tell user interface that
 * the object cannot be added to database for some reasons
 * If more specific exception can be used (NoIdAvailableException, NoTitleException, etc),
 * those exceptions are recommended.
 */
public class CannotAddToDbException extends PENException
{
	public CannotAddToDbException(String message) {
		super(message);
	}
}
