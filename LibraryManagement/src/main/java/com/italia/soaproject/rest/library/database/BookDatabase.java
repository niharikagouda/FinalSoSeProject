package com.italia.soaproject.rest.library.database;
import java.util.List;

import com.italia.soaproject.rest.library.model.Book;


public interface BookDatabase {
	
	/*public void addBook(Book book);*/
		public List<Book> listBooks(String keyword);

		public Boolean isAlreadyIssued(String isbn, Integer userId);
		
		public Boolean issueBook(String isbn, Integer userId);
		
		public Boolean addBook(Book  addBook);
	


}
