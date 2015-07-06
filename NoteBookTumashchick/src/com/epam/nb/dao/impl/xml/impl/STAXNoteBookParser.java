package com.epam.nb.dao.impl.xml.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.epam.nb.dao.DaoException;
import com.epam.nb.dao.ParserDao;
import com.epam.nb.dao.impl.xml.NoteBookTagName;
import com.epam.nb.entity.Note;

public class STAXNoteBookParser implements ParserDao {

	@Override
	public List<Note> parse(String pathToFile) throws DaoException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		List<Note> noteList;
		try {
			InputStream input = new FileInputStream(pathToFile);
			XMLStreamReader streamReader = inputFactory
					.createXMLStreamReader(input);
			noteList = parseProcess(streamReader);
		} catch (XMLStreamException | FileNotFoundException e) {
			throw new DaoException("STAXNoteBookParser error", e);
		}
		return noteList;
	}

	private List<Note> parseProcess(XMLStreamReader streamReader)
			throws XMLStreamException {
		List<Note> noteList = new ArrayList<Note>();
		Note note = null;
		NoteBookTagName elmentName = null;

		while (streamReader.hasNext()) {
			int readElementType = streamReader.next();
			switch (readElementType) {
			case XMLStreamConstants.START_ELEMENT:
				elmentName = NoteBookTagName.getElementTagName(streamReader
						.getLocalName());
				switch (elmentName) {
				case NOTE:
					note = new Note();
					break;
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				String text = streamReader.getText().trim();

				if (text.isEmpty()) {
					break;
				}
				// TITLE, AUTHOR, CREATEDATE, NOTEVALUE
				switch (elmentName) {
				case TITLE:
					note.setTitle(text);
					break;

				case AUTHOR:
					note.setAuthor(text);
					break;

				case CREATEDATE:
					note.setCreateDate(text);
					break;

				case NOTEVALUE:
					note.setNoteValue(text);
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				elmentName = NoteBookTagName.getElementTagName(streamReader
						.getLocalName());
				switch (elmentName) {
				case NOTE:
					noteList.add(note);
				}
			}
		}
		return noteList;
	}

}
