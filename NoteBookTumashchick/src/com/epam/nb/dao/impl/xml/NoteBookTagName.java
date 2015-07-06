package com.epam.nb.dao.impl.xml;

public enum NoteBookTagName {

	NOTEBOOK, NOTE, TITLE, AUTHOR, CREATEDATE, NOTEVALUE;

	public static NoteBookTagName getElementTagName(String element) {
		switch (element) {
		case "NoteBook":
			return NOTEBOOK;
		case "Note":
			return NOTE;
		case "Title":
			return TITLE;
		case "Author":
			return AUTHOR;
		case "CreateDate":
			return CREATEDATE;
		case "NoteValue":
			return NOTEVALUE;
		default:
			throw new EnumConstantNotPresentException(NoteBookTagName.class,
					element);
		}
	}

}
