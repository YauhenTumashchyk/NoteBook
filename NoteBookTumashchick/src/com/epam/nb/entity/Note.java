package com.epam.nb.entity;

import com.epam.nb.logic.DateForNote;

public class Note {

	// default value for the title field when the input value is empty
	public static final String defaultTitle = "No title";
	// default value for the author field when the input value is empty
	public static final String defaultAuthor = "No author";

	private String noteValue;
	private String title;
	private String author;
	private String createDate;

	public String getNoteValue() {
		return noteValue;
	}

	public void setNoteValue(String noteValue) {
		this.noteValue = noteValue;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	// default Note constructor
	public Note(){
		this.noteValue = "";
		this.title = Note.defaultTitle;
		this.author = Note.defaultAuthor;
		this.createDate = DateForNote.dateCreationNote();
	}
	
	// create note contains - note
	public Note(String noteValue) {
		this.noteValue = noteValue;
		this.title = Note.defaultTitle;
		this.author = Note.defaultAuthor;
		this.createDate = DateForNote.dateCreationNote();
	}

	// create note contains - note and tag
	public Note(String noteValue, String title) {
		this.noteValue = noteValue;
		this.title = title;
		this.author = Note.defaultAuthor;
		this.createDate = DateForNote.dateCreationNote();
	}

	// create note contains - note and tag and author
	public Note(String noteValue, String title, String author) {
		this.noteValue = noteValue;
		this.title = title;
		this.author = author;
		this.createDate = DateForNote.dateCreationNote();
	}

	@Override
	public String toString() {
		return "Note [noteValue=" + noteValue + ", title=" + title
				+ ", author=" + author + ", createDate=" + createDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result
				+ ((noteValue == null) ? 0 : noteValue.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (noteValue == null) {
			if (other.noteValue != null)
				return false;
		} else if (!noteValue.equals(other.noteValue))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
