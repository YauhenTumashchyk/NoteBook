package com.epam.nb.dao.impl.memory;

import java.util.List;

import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class MemoryNoteBookDao implements NoteBookDao {

	@Override
	public void addNote(Note newNote) {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		noteBook.addNote(newNote);
	}

	@Override
	public void changeNote(String changedNoteValue, String title, String author) {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		noteBook.changeNote(changedNoteValue, title, author);
	}

	@Override
	public Note findNote(String existNoteValue, String title, String author) {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		Note existNote = noteBook.findNote(existNoteValue, title, author);
		return existNote;
	}

	@Override
	public List<Note> findNoteByDate(String dateRequired) {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		List<Note> sameDateNote = noteBook.findNoteByDate(dateRequired);
		return sameDateNote;
	}

	@Override
	public void deleteNote(String noteValue, String title, String author) {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		noteBook.deleteNote(noteValue, title, author);
	}

	@Override
	public void createNoteBook() {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		noteBook = noteBook.createNoteBook();
	}

	@Override
	public List<Note> findAllNotesCommand() {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		List<Note> notesList = noteBook.findAllNotes();
		return notesList;
	}

}
