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
 * Used to tell user interface that the code field received from UI is empty
 */
public class NoCodeException extends PENException {

	public NoCodeException(String message) {
		super(message);
	}

}
