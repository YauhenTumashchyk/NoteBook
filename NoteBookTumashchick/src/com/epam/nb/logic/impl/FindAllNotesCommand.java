package com.epam.nb.logic.impl;

import java.util.ArrayList;
import java.util.List;

import com.epam.nb.bean.Request;
import com.epam.nb.bean.Response;
import com.epam.nb.dao.DaoException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.factory.DaoFactory;
import com.epam.nb.entity.Note;
import com.epam.nb.logic.Command;
import com.epam.nb.logic.LogicException;

public class FindAllNotesCommand implements Command {
	@Override
	public Response execute(Request request) throws LogicException {
		NoteBookDao dao = DaoFactory.getInstance().getDao();
		List<Note> notesList = new ArrayList<Note>();
		try {
			notesList = dao.findAllNotesCommand();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		
		Response response = new Response();
		response.setListNote(notesList);
		response.setStatus(true);
		response.setStatusMessage("Find All Notes Request confirmed");
		return response;
		
	}


	

}
