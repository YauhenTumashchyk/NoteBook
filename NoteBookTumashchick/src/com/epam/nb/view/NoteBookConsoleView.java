package com.epam.nb.view;

import java.util.List;

import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class NoteBookConsoleView {

	// prints selected note
	public static void print(Note note) {

		String noteValue = note.getNoteValue();
		String title = note.getTitle();
		String author = note.getAuthor();
		String createDate = note.getCreateDate();
		System.out.printf("%s\n %s\n %s\n %s\n%s\n", 
				title, author, createDate,noteValue,"");
	}

	// prints selected list of notes
	public static void print(List<Note> notes) {
		for (int i = 0; i < notes.size(); i++) {
			NoteBookConsoleView.print(notes.get(i));
		}
	}

	// prints given amount of notes
	public static void print(Note... notes) {

		for (Note note : notes) {
			NoteBookConsoleView.print(note);
		}
	}

	// prints all notes in NoteBook
	public static void print(NoteBook noteBook) {
		List<Note> allNotes = noteBook.getNotesList();
		for (int i = 0; i < allNotes.size(); i++) {
			NoteBookConsoleView.print(allNotes.get(i));
		}
	}

}
