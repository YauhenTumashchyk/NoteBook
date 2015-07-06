package com.epam.nb.dao.impl.xml.impl;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.epam.nb.dao.DaoException;
import com.epam.nb.dao.ParserDao;
import com.epam.nb.dao.impl.xml.NoteBookSaxHandler;
import com.epam.nb.entity.Note;

public class SAXNoteBookParser implements ParserDao {

	@Override
	public List<Note> parse(String pathToFile) throws DaoException {
		List<Note> noteList;
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			NoteBookSaxHandler handler = new NoteBookSaxHandler();
			reader.setContentHandler(handler);
			reader.parse(new InputSource(pathToFile));
			noteList = handler.getNoteList();

		} catch (SAXException | IOException e) {
			throw new DaoException("SAXNoteBookParser error", e);
		}
		return noteList;
		
	}

}
