package com.epam.nb.dao;

import java.util.List;

import com.epam.nb.entity.Note;

public interface NoteBookDao {
    
	void addNote(Note note) throws DaoException;
    
	void changeNote(String changedNoteValue,
			String title, String author) throws DaoException;
    
	Note findNote(String existNoteValue, String title, String author) throws DaoException;
    
	List<Note> findNoteByDate(String dateRequired) throws DaoException;
    
	void deleteNote(String noteValue, String title, String author) throws DaoException;
	
	List<Note> findAllNotesCommand() throws DaoException;
	
    void createNoteBook () throws DaoException;

}
