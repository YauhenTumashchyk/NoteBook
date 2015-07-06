package com.epam.nb.logic.impl;

import com.epam.nb.bean.Request;
import com.epam.nb.bean.RequestParam;
import com.epam.nb.bean.Response;
import com.epam.nb.dao.DaoException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.factory.DaoFactory;
import com.epam.nb.entity.Note;
import com.epam.nb.logic.Command;
import com.epam.nb.logic.LogicException;

public class AddNewNoteCommand implements Command {
	
	@Override
	public Response execute(Request request) throws LogicException {
		
		String noteValue = (String) request.getParam(RequestParam.NEW_NOTE_REQUEST);
		String title = (String) request.getParam(RequestParam.NOTE_TITLE_REQUEST);
		String author = (String) request.getParam(RequestParam.NOTE_AUTHOR_REQUEST);

		//!!!add variant without title and author
		Note newNote = new Note(noteValue, title, author);

		NoteBookDao dao = DaoFactory.getInstance().getDao();
		
		try {
			dao.addNote(newNote);
		} catch (DaoException e) {
			throw new LogicException(e); 
		}

		Response response = new Response();
		response.setStatus(true);
		response.setStatusMessage("Add New Note Request confirmed");
		return response;
		
	}

}
