package com.epam.nb.dao.impl.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.epam.nb.dao.DaoException;
import com.epam.nb.dao.impl.memory.NoteBookProvider;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class FileOperator {
	// The name of the file to read / write
	private final static String FILE_NAME = "resourses/NoteBook.txt";

	public static String getFileName() {
		return FILE_NAME;
	}

	// check if file exists. If true - delete file and create new from notebook
	public void createNoteBookFile(NoteBook myNoteBook) throws DaoException {
		File notebookFile = new File(FILE_NAME);
		if (notebookFile.exists()) {
			notebookFile.delete();
		}
		try {
			notebookFile.createNewFile();
		} catch (IOException e) {
			throw new DaoException("Create NoteBook file error", e);
		}
	}

	// add note to the file
	public void addNoteToFile(Note note) throws DaoException {
		File notebookFile = new File(FILE_NAME);
		try {
			if (notebookFile.exists()) {
				writeNoteInFile(note);
			} else {
				NoteBook noteBook = NoteBookProvider.getInstance()
						.getNoteBook();

				createNoteBookFile(noteBook);
				addNoteToFile(note);
			}
		} catch (Exception e) {
			throw new DaoException("Add note to file error", e);
		}
		System.out.println(notebookFile.getAbsolutePath());

	}

	private void writeNoteInFile(Note note) throws DaoException {

		try (FileWriter fileWriter = new FileWriter(FILE_NAME, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

			// write Note to file
			bufferedWriter.write(note.getTitle());
			bufferedWriter.newLine();
			bufferedWriter.write(note.getAuthor());
			bufferedWriter.newLine();
			bufferedWriter.write(note.getCreateDate());
			bufferedWriter.newLine();
			bufferedWriter.write(note.getNoteValue());
			bufferedWriter.newLine();
			bufferedWriter.write("\n");
			bufferedWriter.flush();

		} catch (Exception e) {
			throw new DaoException("Add note to file error", e);
		}

		System.out.println("Note is saved in file " + FILE_NAME);
	}

	public void changeNoteInFile(String changedNoteValue, String title,
			String author) throws DaoException {
		String searchTitle = "Title ".concat(title);
		String searchAuthor = "Author ".concat(author);
		changedNoteValue = "NoteValue  ".concat(changedNoteValue);

		File notebookFile = new File(FILE_NAME);

		if (!notebookFile.isFile()) {
			System.out.println("Parameter is not an existing file");
			return;
		}

		// Make new file later be renamed to the original filename
		File tempFile = new File(notebookFile.getAbsolutePath() + ".tmp");
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
				FILE_NAME));
				BufferedWriter bufferedWriter = new BufferedWriter(
						new FileWriter(tempFile))) {

			StringBuffer stringBuffer = new StringBuffer();
			String line = null;
			// Read from the original file and write to the new
			// unless content matches data to be removed.
			while ((line = bufferedReader.readLine()) != null) {

				if (!(line.trim().equals(searchTitle) | line.trim().equals(
						searchAuthor))) {
					bufferedWriter.write(line);
					bufferedWriter.newLine();
				}

				if (line.trim().equals(searchTitle)) {
					stringBuffer.append(line);
					stringBuffer.append("\n");
					line = bufferedReader.readLine();

					if (line.trim().equals(searchAuthor)) {
						stringBuffer.append(line);
						stringBuffer.append("\n");
						line = bufferedReader.readLine();
						stringBuffer.append(line);
						stringBuffer.append("\n");
						line = bufferedReader.readLine();
						stringBuffer.append(changedNoteValue);
						stringBuffer.append("\n");
						bufferedWriter.write(stringBuffer.toString());
						stringBuffer.delete(0, stringBuffer.length());
					} else {
						bufferedWriter.write(stringBuffer.toString());
						stringBuffer.delete(0, stringBuffer.length());
					}
				}
			}
			bufferedWriter.flush();

		} catch (IOException e) {
			throw new DaoException("Change Note in file error", e);
		}
		// Delete the original file
		if (!notebookFile.delete()) {
			System.out.println("Could not delete file");
			return;
		}

		// Rename the new file to the filename the original file had.
		if (!tempFile.renameTo(notebookFile))
			System.out.println("Could not rename file");
	}

	public void findAllNotesInFile(String pathToFile) throws DaoException {
		File notebookFile = new File(FILE_NAME);
		try {
			if (notebookFile.exists()) {
				readFromFile(pathToFile);
			} else {
				throw new FileNotFoundException();
			}
		} catch (IOException e) {
			throw new DaoException("Change Note in file error", e);
		}
	}

	public void readFromFile(String pathToFile) throws DaoException {
		String line = null;

		try (FileReader fileReader = new FileReader(pathToFile);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			throw new DaoException("Change Note in file error", e);
		}
	}

}
