package com.epam.nb.bean;

import java.util.List;

import com.epam.nb.entity.Note;

public class Response {

	private boolean status = false;
	private String statusMessage;
	private String errorMessage;


	private Note note;
	private List<Note> listNote;


	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public List<Note> getListNote() {
		return listNote;
	}

	public void setListNote(List<Note> listNote) {
		this.listNote = listNote;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public void printStatusMessage(boolean status) {
		if (status == true) {
			System.out.println(getStatusMessage());
		} else {
			System.err.println("Request unconfirmed. Can`t complete the action");
		}

	}

}
