package com.epam.nb.dao.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.impl.db.DbNoteBookDao;
import com.epam.nb.dao.impl.file.FileNoteBookDao;
import com.epam.nb.dao.impl.memory.MemoryNoteBookDao;
import com.epam.nb.dao.impl.xml.XMLNoteBookDao;

public class DaoFactory {

	// create singleton of the DaoFactory class
	private static final DaoFactory daoFactory = new DaoFactory();

	// link to source property file - sourcetype.properties
	private final String linkToSoursetype = "sourcetype";
	private final String daoTypeProperty = "dao.type";
	private SourceType daoType;

	private Map<SourceType, NoteBookDao> dao = new HashMap<>();

	// DaoFactory constructor
	private DaoFactory() {

		// get SourceType from sourcetype.properties for the DaoFactory()
		ResourceBundle rb = ResourceBundle.getBundle(linkToSoursetype);
		daoType = SourceType.valueOf(rb.getString(daoTypeProperty));

		dao.put(SourceType.MEMORY, new MemoryNoteBookDao());
		dao.put(SourceType.DB, new DbNoteBookDao());
		dao.put(SourceType.XML, new XMLNoteBookDao());
		dao.put(SourceType.FILE, new FileNoteBookDao());
	}

	public static DaoFactory getInstance() {
		return daoFactory;
	}

	public NoteBookDao getDao() {
		return dao.get(daoType);
	}

}

