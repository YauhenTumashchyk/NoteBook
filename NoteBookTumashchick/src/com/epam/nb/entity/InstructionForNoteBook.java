/*
 * This class will contain instructions for working with NoteBook
 */

package com.epam.nb.entity;

public class InstructionForNoteBook {

	// version of the program
	public static final String VERSION = "1.7.2";
	// author of the program
	public static final String AUTHOR = "Yauhen Tumashchyck";

	public static void versionCanges() {
		System.out.println(
				"--->>> v1.7 - SAX parser added \n"+
				"--->>> v1.7.1 - DaoXMLParserFactory added \n"+
				"--->>> v1.7.2 - StAX and DOM parsers added \n"		);
	}

}
