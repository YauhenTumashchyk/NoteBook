package com.epam.nb.controller;

import org.apache.log4j.Logger;

import com.epam.nb.bean.Request;
import com.epam.nb.bean.Response;
import com.epam.nb.logic.Command;
import com.epam.nb.logic.LogicException;

public class NoteBookController {
	private static final Logger log = Logger.getLogger(NoteBookController.class);
	private NoteBookCommandHelper commandHelper = new NoteBookCommandHelper();



	public Response doCommand(CommandName commandName, Request request) {
		
		Command command = commandHelper.getCommand(commandName);
		Response response = new Response();
		try {
			response = command.execute(request);
			return response;

		} catch (LogicException e) {
			e.printStackTrace();
			response.setErrorMessage("Error while executing the command");
			log.error("NoteBookController - doCommand error", e);
			response.setStatus(false);
		}
		return response;
	}
}
