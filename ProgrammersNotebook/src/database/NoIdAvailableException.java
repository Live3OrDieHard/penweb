package database;

import exceptions.PENException;

public class NoIdAvailableException extends PENException {

	public NoIdAvailableException(String message) {
		super(message);
	}

}
