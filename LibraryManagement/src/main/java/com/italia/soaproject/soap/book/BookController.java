package com.italia.soaproject.soap.book;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class BookController {
	
	
	@WebMethod
	public boolean removeBook(@WebParam(name = "isbn") String isbn) {
		
		
		
		return true;
	}

}
