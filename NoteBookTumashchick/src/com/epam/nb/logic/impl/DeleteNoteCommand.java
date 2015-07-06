package com.epam.nb.logic.impl;

import com.epam.nb.bean.Request;
import com.epam.nb.bean.RequestParam;
import com.epam.nb.bean.Response;
import com.epam.nb.dao.DaoException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.factory.DaoFactory;
import com.epam.nb.logic.Command;
import com.epam.nb.logic.LogicException;

public class DeleteNoteCommand implements Command {

	@Override
	public Response execute(Request request) throws LogicException {
		
		String noteValue = (String) request.getParam(RequestParam.EXIST_NOTE_REQUEST);
		String title = (String) request.getParam(RequestParam.NOTE_TITLE_REQUEST);
		String author = (String) request.getParam(RequestParam.NOTE_AUTHOR_REQUEST);
	
		NoteBookDao dao = DaoFactory.getInstance().getDao();

		try {
			dao.deleteNote(noteValue, title, author);
		} catch (DaoException e) {
			throw new LogicException(e);
		}

		Response response = new Response();
		response.setStatus(true);
		response.setStatusMessage("Delete Note Request confirmed");
		return response;
	}

}
