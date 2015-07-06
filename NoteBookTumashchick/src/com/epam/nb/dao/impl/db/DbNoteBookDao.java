package com.epam.nb.dao.impl.db;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.nb.dao.DaoException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.impl.db.conpool.ConnectionPool;
import com.epam.nb.dao.impl.db.conpool.ConnectionPoolException;
import com.epam.nb.entity.Note;

public class DbNoteBookDao implements NoteBookDao {

	private final String sqlCreateTable = "CREATE TABLE NoteBook "
			+ "(TITLE           TEXT     NOT NULL, "
			+ " AUTHOR          TEXT     NOT NULL, "
			+ " CREATEDATE      TEXT     NOT NULL, "
			+ " NOTEVALUE       TEXT     NOT NULL)";
	private final String sqlAddNote = "INSERT INTO NoteBook "
			+ "(TITLE,AUTHOR,CREATEDATE,NOTEVALUE) VALUES (?,?,?,?)";

	private final String sqlFindAllNotes = "SELECT * FROM NoteBook";
	private final String findNoteByDate = "SELECT * FROM NoteBook WHERE CREATEDATE LIKE '";

	private final String dbFilename = "resourses/NoteBook.db";

	private Connection getConnection() throws DaoException{
		Connection connection;
		try {
			connection = ConnectionPool.getInstance().takeConnection();
		} catch (ConnectionPoolException e) {
			throw new DaoException("Create NoteBook Database error", e);
		}
		return connection;
	}
	
	@Override
	public void createNoteBook() throws DaoException {
		Connection con=null;
		Statement statement = null;
		
		File dbFile = new File(dbFilename);
		// check if file with DB exists - delete DB
		if (dbFile.exists()) {
			dbFile.delete();
		}
		try{			
			con = getConnection();
			statement = con.createStatement();
			statement.executeUpdate(sqlCreateTable);

		} catch (SQLException e) {
			throw new DaoException("Create NoteBook Database error", e);
		}
		finally{
			ConnectionPool.getInstance().closeConnection(con, statement);
		}
	}

	@Override
	public void addNote(Note note) throws DaoException {
		Connection con=null;
		PreparedStatement preparedStatement = null;
		try {
			con = getConnection();
			preparedStatement = con.prepareStatement(sqlAddNote);
			preparedStatement.setString(1, note.getTitle());
			preparedStatement.setString(2, note.getAuthor());
			preparedStatement.setString(3, note.getCreateDate());
			preparedStatement.setString(4, note.getNoteValue());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException("Add note to Database error", e);
		}finally{
			ConnectionPool.getInstance().closeConnection(con, preparedStatement);
		}
		
	}

	@Override
	public List<Note> findNoteByDate(String dateRequired) throws DaoException {
		Connection con=null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		List<Note> listNotes = new ArrayList<Note>();
		Note note;
		String noteValue, title, author, createDate;

		try {
			con = getConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(findNoteByDate + dateRequired
					+ "'");

			while (resultSet.next()) {
				noteValue = resultSet.getString(4);
				title = resultSet.getString(1);
				author = resultSet.getString(2);
				createDate = resultSet.getString(3);
				note = new Note(noteValue, title, author);
				note.setCreateDate(createDate);
				listNotes.add(note);
			}
		} catch (SQLException e) {
			throw new DaoException("Find all notes in Database error", e);
		} finally {
			ConnectionPool.getInstance().closeConnection(con, statement, resultSet);;
		}
		return listNotes;
	}



	@Override
	public List<Note> findAllNotesCommand() throws DaoException {
		Connection con=null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Note> listNotes = new ArrayList<Note>();
		Note note;
		String noteValue, title, author, createDate;

		try{
			con = getConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(sqlFindAllNotes);

			while (resultSet.next()) {
				noteValue = resultSet.getString(4);
				title = resultSet.getString(1);
				author = resultSet.getString(2);
				createDate = resultSet.getString(3);
				note = new Note(noteValue, title, author);
				note.setCreateDate(createDate);
				listNotes.add(note);
			}
		} catch (SQLException e) {
			throw new DaoException("Find all notes in Database error", e);
		} finally {
			ConnectionPool.getInstance().closeConnection(con, statement, resultSet);;
		}
		return listNotes;
	}
	
	@Override
	public Note findNote(String existNoteValue, String title, String author) throws DaoException {
		
		Connection con=null;
		Statement statement = null;
		ResultSet resultSet = null;
		String findNote = "SELECT * FROM NoteBook WHERE TITLE LIKE '"
				+ title + "' AND AUTHOR LIKE '" + author + "' AND NOTEVALUE LIKE '"
				+ existNoteValue +"'";
		Note note = null;
		String tmpNoteValue, tmpTitle, tmpAuthor, tmpCreateDate;

		try {
			con = getConnection();
			statement = con.createStatement();
		
			resultSet = statement.executeQuery(findNote);

			while (resultSet.next()) {
				tmpNoteValue = resultSet.getString(4);
				tmpTitle = resultSet.getString(1);
				tmpAuthor = resultSet.getString(2);
				tmpCreateDate = resultSet.getString(3);
				note = new Note(tmpNoteValue, tmpTitle, tmpAuthor);
				note.setCreateDate(tmpCreateDate);
				}
		} catch (SQLException e) {
			throw new DaoException("Find all notes in Database error", e);
		} finally {
			ConnectionPool.getInstance().closeConnection(con, statement, resultSet);;
		}
		return note;
	}
	
	@Override
	public void changeNote(String changedNoteValue, String title, String author) {
	}
	
	@Override
	public void deleteNote(String noteValue, String title, String author) {
	}
}
