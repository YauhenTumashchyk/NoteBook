package com.epam.nb.dao;


public class DaoException extends Exception {

	private static final long serialVersionUID = 8514402019184520216L;

	public DaoException(String message, Exception e) {
		super(message, e);
	}

	public DaoException(Exception e) {
		super(e);
	}
}
