package com.epam.nb.logic;

public class LogicException extends Exception {

	private static final long serialVersionUID = 7706774865670274518L;

	public LogicException(String message, Exception e) {
		super(message, e);
	}

	public LogicException(Exception e) {
		super(e);
	}

}
