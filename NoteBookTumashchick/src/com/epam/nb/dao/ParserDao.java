package com.epam.nb.dao;

import java.util.List;

import com.epam.nb.entity.Note;

public interface ParserDao {
	
	List<Note> parse(String pathToFile) throws DaoException;

}
