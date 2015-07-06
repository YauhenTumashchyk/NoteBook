package com.epam.nb.dao.impl.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.nb.entity.Note;

public class NoteBookSaxHandler extends DefaultHandler {

	private List<Note> noteList = new ArrayList<Note>();
	private Note note;
	private StringBuilder text;

	public List<Note> getNoteList() {
		return noteList;
	}

	public void startDocument() throws SAXException {
		System.out.println("Parsing started.");
	}

	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.");
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("startElement -> " + "uri: " + uri + ", localName: "
				+ localName + ", qName: " + qName);

		text = new StringBuilder();
		if (qName.equals("Note")) {
			note = new Note();
		}
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		NoteBookTagName tagName = NoteBookTagName.valueOf(qName.toUpperCase()
				.replace("-", "_"));
		switch (tagName) {
		case TITLE:
			note.setTitle(text.toString());
			break;
		case AUTHOR:
			note.setAuthor(text.toString());
			break;
		case CREATEDATE:
			note.setCreateDate(text.toString());
			break;
		case NOTEVALUE:
			note.setNoteValue(text.toString());
			break;
		case NOTE:
			noteList.add(note);
			note = null;
			break;
		case NOTEBOOK:
			break;
		default:
			break;
		}
	}

	public void warning(SAXParseException exception) {
		System.err.println("Warning: line " + exception.getLineNumber() + ": "
				+ exception.getMessage());
	}
	public void error(SAXParseException exception) {
		System.err.println("ERROR: line " + exception.getLineNumber() + ": "
				+ exception.getMessage());
	}
	public void fatalError(SAXParseException exception) {
		System.err.println("FATAL: line " + exception.getLineNumber() + ": "
				+ exception.getMessage());
	}
}
