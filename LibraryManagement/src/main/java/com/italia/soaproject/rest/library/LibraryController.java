package com.italia.soaproject.rest.library;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.italia.soaproject.rest.library.database.BookDatabase;
import com.italia.soaproject.rest.library.database.BookDatabaseImpl;
import com.italia.soaproject.rest.library.model.Book;
import com.italia.soaproject.rest.user.database.UserDatabase;
import com.italia.soaproject.rest.user.database.UserDatabaseImpl;
import com.italia.soaproject.rest.user.model.Login;

@RestController
public class LibraryController {
	
	BookDatabase udb = new BookDatabaseImpl();
	
	
	
	@RequestMapping(value = "/searchBooks/{keyword}", method = RequestMethod.GET)
    public List<Book> searchBooks(@PathVariable("keyword") String keyword) {
		
		if(keyword == null) {
			return new ArrayList<Book>();
		}
		
		return udb.listBooks(keyword);
		
    }
	
	
	@RequestMapping(value = "/issueBook", method = RequestMethod.POST)
    public Boolean issueBook(@RequestParam(name = "bookId") String bookId, @RequestParam(name = "userId") String userId) {
		
		if(bookId == null || userId == null) {
			return false;
		}
		
		Integer user = Integer.parseInt(userId);
		
		if(udb.isAlreadyIssued(bookId, user)) {
			return false;
		}
		
		return udb.issueBook(bookId, user);
		
	}

	
	
		
		
		
		
		
		
}		
    
	
	
	
	
	
	
	


