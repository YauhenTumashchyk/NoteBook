package com.epam.nb.logic.impl;

import java.util.ArrayList;
import java.util.List;

import com.epam.nb.bean.Request;
import com.epam.nb.bean.RequestParam;
import com.epam.nb.bean.Response;
import com.epam.nb.dao.DaoException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.factory.DaoFactory;
import com.epam.nb.entity.Note;
import com.epam.nb.logic.Command;
import com.epam.nb.logic.LogicException;

public class FindNoteByDateCommand implements Command {

	@Override
	public Response execute(Request request) throws LogicException {
		
		String dateRequired = (String) request.getParam(RequestParam.FIND_NOTE_BY_DATE_REQUEST);
		
		NoteBookDao dao = DaoFactory.getInstance().getDao();
		List<Note> sameDateNote = new ArrayList<Note>();
		try {
			sameDateNote = dao.findNoteByDate(dateRequired);
		} catch (DaoException e) {
			throw new LogicException(e);
		}

		Response response = new Response();
		response.setListNote(sameDateNote);
		response.setStatus(true);
		response.setStatusMessage("Find Note By Date Request confirmed");
		return response;
	}

}
