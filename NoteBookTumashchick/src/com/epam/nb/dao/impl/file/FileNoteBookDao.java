package com.epam.nb.dao.impl.file;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.nb.dao.DaoException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.impl.memory.NoteBookProvider;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class FileNoteBookDao implements NoteBookDao {
	
	private static final Logger log = Logger.getLogger(FileNoteBookDao.class);

	@Override
	public void createNoteBook() throws DaoException {

		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		FileOperator fileOperator = new FileOperator();
		try {
			fileOperator.createNoteBookFile(noteBook);
		} catch (DaoException e) {
			log.error("Create NoteBook file error", e);
			throw new DaoException("Create NoteBook file error", e);
		}
	}

	@Override
	public void addNote(Note note) throws DaoException {
		FileOperator fileOperator = new FileOperator();
		try {
			fileOperator.addNoteToFile(note);
		} catch (DaoException e) {
			log.error("Add Note to file error", e);
			throw new DaoException("Add Note to file error", e);
		}
	}

	@Override
	public void changeNote(String changedNoteValue, String title, String author)
			throws DaoException {
		FileOperator fileOperator = new FileOperator();
		try {

			fileOperator.changeNoteInFile(changedNoteValue, title, author);

		} catch (DaoException e) {
			log.error("Change Note in file error", e);
			throw new DaoException("Change Note in file error", e);
		}
	}

	@Override
	public List<Note> findAllNotesCommand() throws DaoException {

		FileOperator fileOperator = new FileOperator();
		try {
			fileOperator.findAllNotesInFile(FileOperator.getFileName());
		} catch (DaoException e) {
			log.error("Find all Notes in file error", e);
			throw new DaoException("Find all Notes in file error", e);
		}
		return null;
	}

	@Override
	public Note findNote(String existNoteValue, String title, String author) {
		// Need to clarify committed action
		return null;
	}
	
	@Override
	public List<Note> findNoteByDate(String dateRequired) {
		// Need to clarify committed action
		return null;
		
	}
	
	@Override
	public void deleteNote(String noteValue, String title, String author) {
		// TODO Auto-generated method stub
	}
}
