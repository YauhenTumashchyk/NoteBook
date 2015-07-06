package com.epam.nb.view;

import org.apache.log4j.Logger;

import com.epam.nb.bean.Request;
import com.epam.nb.bean.RequestParam;
import com.epam.nb.bean.Response;
import com.epam.nb.controller.CommandName;
import com.epam.nb.controller.NoteBookController;
import com.epam.nb.entity.InstructionForNoteBook;

public class Main {
	private static final Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		log.debug("Start processing");
		System.out.println("NoteBook --->>> version "
				+ InstructionForNoteBook.VERSION + "\nAuthor "
				+ InstructionForNoteBook.AUTHOR);
		InstructionForNoteBook.versionCanges();

		NoteBookController controller = new NoteBookController();
		Request request = new Request();
		Response response = new Response();
		
// request to create notebook
//		request.setParam(RequestParam.NEW_NOTEBOOK_REQUEST, null);
//		response = controller.doCommand(CommandName.NEW_NOTEBOOK_COMMAND,
//				request);
//		response.printStatusMessage(response.isStatus());
//		System.out.println("*********************************");

// request to add "i" notes
//		for (int i = 0; i < 1; i++) {
//			request.setParam(RequestParam.NOTE_TITLE_REQUEST, "MyNote");
//			request.setParam(RequestParam.NOTE_AUTHOR_REQUEST, "Tumashchick");
//			request.setParam(RequestParam.NEW_NOTE_REQUEST, "NoteValue - " + String.valueOf(i+1));
//			response = controller.doCommand(CommandName.ADD_NEW_NOTE_COMMAND,
//					request);
//			System.out.println("*********************************");
//		}
//		response.printStatusMessage(response.isStatus());
		
// request to all find notes
		request.setParam(RequestParam.FIND_ALL_NOTES_REQUEST, null);
		response = controller.doCommand(CommandName.FIND_ALL_NOTES_COMMAND,
				request);
		response.printStatusMessage(response.isStatus());
		NoteBookConsoleView.print(response.getListNote());
		System.out.println("*********************************");
		
//		request.setParam(RequestParam.FIND_NOTE_BY_DATE_REQUEST, "2015/07/01 17:06:24");
//		response = controller.doCommand(CommandName.FIND_NOTE_BY_DATE_COMMAND,
//				request);
//		response.printStatusMessage(response.isStatus());
//
//		System.out.println("*********************************");
		
		
//		
//		// request to 2 add notes
//				for (int i = 0; i < 2; i++) {
//					request.setParam(RequestParam.NOTE_TITLE_REQUEST, "TestNote");
//					request.setParam(RequestParam.NOTE_AUTHOR_REQUEST, "Anonim");
//					request.setParam(RequestParam.NEW_NOTE_REQUEST, "NoteValue - " + String.valueOf(i+1));
//					response = controller.doCommand(CommandName.ADD_NEW_NOTE_COMMAND,
//							request);
//				}
//		
//		request.setParam(RequestParam.NOTE_TITLE_REQUEST, "MyNote");
//		request.setParam(RequestParam.NOTE_AUTHOR_REQUEST, "Tumashchick");
//		request.setParam(RequestParam.CHANGED_NOTE_REQUEST, "This VALUE is changed");
//		response = controller.doCommand(CommandName.CHANGE_NOTE_COMMAND,
//				request);
//		System.out.println("*********************************");

		if (log.isDebugEnabled()) {
		    log.debug("done");
		}
	}

}
