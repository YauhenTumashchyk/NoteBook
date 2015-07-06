package com.epam.nb.dao.impl.xml;

import java.util.List;

import com.epam.nb.dao.DaoException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.ParserDao;
import com.epam.nb.dao.factory.DaoXMLParserFactory;
import com.epam.nb.entity.Note;

public class XMLNoteBookDao implements NoteBookDao {
	private static final String PATH_XMLFILE = "resourses/NoteBook.xml";

	@Override
	public List<Note> findAllNotesCommand() throws DaoException {
		List<Note> noteList;
		ParserDao parserDao = DaoXMLParserFactory.getInstance().getDao();
		noteList = parserDao.parse(PATH_XMLFILE);
		return noteList;
	}

	@Override
	public void addNote(Note note) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeNote(String changedNoteValue, String title, String author) {
		// TODO Auto-generated method stub

	}

	@Override
	public Note findNote(String existNoteValue, String title, String author) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public List<Note> findNoteByDate(String dateRequired) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteNote(String noteValue, String title, String author) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createNoteBook() {
		// TODO Auto-generated method stub

	}

}
