/*
 * —проектируйте классы-сущности системы:  Note,  NoteBook. ѕереопределите дл€ этих классов методы equals, 
 * hashCode и toString().Ќапишите тесты, позвол€ющие проверить корректность работы экземпл€ров этих классов.
 */

package com.epam.nb.entity;

import java.util.ArrayList;
import java.util.List;

import com.epam.nb.dao.impl.memory.NoteBookProvider;

public class NoteBook {

	private List<Note> notesList = new ArrayList<>();

	public List<Note> getNotesList() {
		return notesList;
	}

	// !!!!Check this method.
	public NoteBook createNoteBook() {
		NoteBook newNoteBook = NoteBookProvider.getInstance().getNoteBook();
		newNoteBook.notesList.clear();
		return newNoteBook;
	}

	// add note
	public void addNote(Note newNote) {
		notesList.add(newNote);
	}

	// delete selected note
	public void deleteNote(String noteValue, String title, String author) {
		// check value of NoteBook. If empty - return
		if (notesList.size() == 0) {
			return;
		}

		Note existNote;
		String existNoteValue, existNoteTitle, existNoteAuthor;
		for (int i = 0; i < notesList.size(); i++) {

			existNote = notesList.get(i);
			existNoteValue = existNote.getNoteValue();
			existNoteTitle = existNote.getTitle();
			existNoteAuthor = existNote.getAuthor();

			if ((existNoteValue.equals(noteValue))
					& (existNoteTitle.equals(title))
					& (existNoteAuthor.equals(author))) {

				notesList.remove(i);
			} else {
				return;
			}
		}
	}

	// change selected note
	public void changeNote(String changedNoteValue, String title, String author) {

		// check value of NoteBook. If empty - return
		if (notesList.size() == 0) {
			return;
		}

		Note existNote;
		String existNoteTitle, existNoteAuthor;
		for (int i = 0; i < notesList.size(); i++) {

			existNote = notesList.get(i);
			existNoteTitle = existNote.getTitle();
			existNoteAuthor = existNote.getAuthor();

			if ((existNoteTitle.equals(title))
					& (existNoteAuthor.equals(author))) {

				existNote.setNoteValue(changedNoteValue);

				notesList.set(i, existNote);

			} else {
				return;
			}
		}
	}

	// find selected note and return it
	public Note findNote(String existNoteValue, String title, String author) {

		// check value of NoteBook. If empty - return
		if (!(notesList.size() == 0)) {
			Note existNote;
			String getExistNoteTitle, existNoteTitle, existNoteAuthor;
			for (int i = 0; i < notesList.size(); i++) {

				existNote = notesList.get(i);
				getExistNoteTitle = existNote.getNoteValue();
				existNoteTitle = existNote.getTitle();
				existNoteAuthor = existNote.getAuthor();

				if ((getExistNoteTitle.equals(existNoteValue))
						& (existNoteTitle.equals(title))
						& (existNoteAuthor.equals(author))) {
					return existNote;
				}
			}
		}
		return null;
	}

	// find selected date in notes and return all same notes
	public List<Note> findNoteByDate(String dateRequired) {
		// check value of NoteBook. If empty - return
		if (!(notesList.size() == 0)) {
			List<Note> sameDateNote = new ArrayList<>();
			Note existNote;
			String getExistNoteDate;
			for (int i = 0; i < notesList.size(); i++) {
				existNote = notesList.get(i);
				getExistNoteDate = existNote.getCreateDate();

				if (getExistNoteDate.contains(dateRequired)) {
					sameDateNote.add(existNote);
				}
			}
			return sameDateNote;
		}
		return null;
	}

	// find all notes in NoteBook and return them
	public List<Note> findAllNotes() {

		// check value of NoteBook. If empty - return
		if (notesList.size() == 0) {
			return null;
		}
		return getNotesList();
	}

}
