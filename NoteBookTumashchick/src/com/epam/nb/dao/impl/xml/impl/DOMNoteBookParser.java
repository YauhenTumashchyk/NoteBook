package com.epam.nb.dao.impl.xml.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.nb.dao.DaoException;
import com.epam.nb.dao.ParserDao;
import com.epam.nb.entity.Note;

public class DOMNoteBookParser implements ParserDao {

	@Override
	public List<Note> parse(String pathToFile) throws DaoException {
		List<Note> noteList;
		String Title = "Title";
		String Author = "Author";
		String CreateDate = "CreateDate";
		String NoteValue = "NoteValue";

		
		DOMParser parser = new DOMParser();
		try {
			parser.parse(pathToFile);
			Document document = parser.getDocument();
			Element root = document.getDocumentElement();
			noteList = new ArrayList<Note>();
			
			NodeList noteNodes = root.getElementsByTagName("Note");
			Note note = null;
			
			for (int i = 0; i < noteNodes.getLength(); i++) {
				note = new Note();
				Element noteElement = (Element) noteNodes.item(i);
				
				note.setTitle(getSingleChild(noteElement,Title).getTextContent().trim());
				note.setAuthor(getSingleChild(noteElement,Author).getTextContent().trim());
				note.setCreateDate(getSingleChild(noteElement,CreateDate).getTextContent().trim());
				note.setNoteValue(getSingleChild(noteElement,NoteValue).getTextContent().trim());
				noteList.add(note);
			}
		
		} catch (SAXException | IOException e) {
			throw new DaoException("DOMNoteBookParser error", e);
		}
		
		return noteList;
	}
	
	private Element getSingleChild(Element element, String childName){
		
		NodeList nList = element.getElementsByTagName(childName);
		Element child = (Element) nList.item(0);
		return child;
	}



}
