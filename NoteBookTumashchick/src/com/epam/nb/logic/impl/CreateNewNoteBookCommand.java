package com.epam.nb.logic.impl;

import com.epam.nb.bean.Request;
import com.epam.nb.bean.Response;
import com.epam.nb.dao.DaoException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.factory.DaoFactory;
import com.epam.nb.logic.Command;
import com.epam.nb.logic.LogicException;

public class CreateNewNoteBookCommand implements Command {
	
	@Override
	public Response execute(Request request) throws LogicException {

		NoteBookDao dao = DaoFactory.getInstance().getDao();

		try {
			dao.createNoteBook();
		} catch (DaoException e) {
			throw new LogicException(e); 
		}
		
		Response response = new Response();
		response.setStatus(true);
		response.setStatusMessage("Create New NoteBook Request confirmed");
		return response;
	}

}
