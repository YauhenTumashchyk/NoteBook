package com.epam.nb.dao.impl.db.conpool;

import java.util.ResourceBundle;

public class DBResourceManager {

	private final static DBResourceManager instance = new DBResourceManager();
	private final String linkDbProperties = "db";
	
	private ResourceBundle bundle = ResourceBundle.getBundle(linkDbProperties);
	
	public static DBResourceManager getInstance(){
		return instance;
	}
	
	public String getValue(String key){
		return bundle.getString(key);
	}
	
}
