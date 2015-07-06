package com.epam.nb.entity;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.nb.dao.DaoException;
import com.epam.nb.dao.impl.file.FileOperator;
import com.epam.nb.dao.impl.memory.NoteBookProvider;

public class TestFileOperator {
  
  private FileOperator fileOperator;
  private NoteBook myNoteBook;
  private Note testNote;
  @BeforeClass
  public void beforeClass() {
	  fileOperator = new FileOperator();
	  myNoteBook = NoteBookProvider.getInstance().getNoteBook();
	  testNote = new Note("This is test value");
	  myNoteBook.addNote(testNote);
  }

  @AfterClass
  public void afterClass() {
	  fileOperator = null;
	  
  }
  
@Test
public void testaddNoteToFile() throws DaoException {

	fileOperator.addNoteToFile(testNote);
	
	fileOperator.findAllNotesInFile(FileOperator.getFileName());
}

//@DataProvider()
//public Object[][] getNoteBook() {
//	  return new Object[][] {
//			  new Object[] {myNoteBook},
//	  };
//} 
//  
//  
//@Test(dataProvider = "getNoteBook")
//public void testWriteInFile(NoteBook myNoteBook) throws IOException {
//	
//	fileOperator.writeInFile(myNoteBook);
//	
//	File file = new File(fileOperator.getFileName());
//	Assert.assertTrue(file.exists());
//}
//  
//  @DataProvider()
//  public Object[][] dp() {
//	  return new Object[][] {
//			  new Object[] { 1, "a" },
//			  new Object[] { 2, "b" },
//	  };
//  }
//
//  @Test(dataProvider = "dp")
//  public void testWriteInFile(NoteBook myNoteBook) {
//	  
//	  
//	  
//	  
//  }
}
