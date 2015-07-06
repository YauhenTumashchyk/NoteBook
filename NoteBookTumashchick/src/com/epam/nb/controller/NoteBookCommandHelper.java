package com.epam.nb.controller;

import java.util.HashMap;
import java.util.Map;

import com.epam.nb.logic.Command;
import com.epam.nb.logic.impl.AddNewNoteCommand;
import com.epam.nb.logic.impl.ChangeNoteCommand;
import com.epam.nb.logic.impl.CreateNewNoteBookCommand;
import com.epam.nb.logic.impl.DeleteNoteCommand;
import com.epam.nb.logic.impl.FindAllNotesCommand;
import com.epam.nb.logic.impl.FindNoteByDateCommand;
import com.epam.nb.logic.impl.FindNoteCommand;


public class NoteBookCommandHelper {

	private Map<CommandName, Command> commands = new HashMap<>();

	NoteBookCommandHelper() {

		commands.put(CommandName.NEW_NOTEBOOK_COMMAND, new CreateNewNoteBookCommand());
		commands.put(CommandName.ADD_NEW_NOTE_COMMAND, new AddNewNoteCommand());
		commands.put(CommandName.FIND_NOTE_COMMAND, new FindNoteCommand());
		commands.put(CommandName.FIND_NOTE_BY_DATE_COMMAND, new FindNoteByDateCommand());
		commands.put(CommandName.FIND_ALL_NOTES_COMMAND, new FindAllNotesCommand());
		commands.put(CommandName.CHANGE_NOTE_COMMAND, new ChangeNoteCommand());
		commands.put(CommandName.DELETE_NOTE_COMMAND, new DeleteNoteCommand());

	}

	public Command getCommand(CommandName command) {

		return commands.get(command);

	}

}
