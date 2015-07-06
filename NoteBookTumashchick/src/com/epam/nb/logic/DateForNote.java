package com.epam.nb.logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateForNote {

	// HOUR - contains one hour in millisecond for the dateOfCreationNote()
	// time correction for the current user
	private static final long HOUR = 3600000;
	
	// generates date of creation for the note
	public static String dateCreationNote() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		Date newDate = new Date(new Date().getTime() + DateForNote.HOUR);
		return dateFormat.format(newDate);
	}
	
}
