package com.epam.nb.dao.impl.db.conpool;

public class ConnectionPoolException extends Exception{

	private static final long serialVersionUID = -8382226160850212805L;

	public ConnectionPoolException(String message, Exception e) {
		super(message, e);
	}

	public ConnectionPoolException(Exception e) {
		super(e);
	}
	
}
