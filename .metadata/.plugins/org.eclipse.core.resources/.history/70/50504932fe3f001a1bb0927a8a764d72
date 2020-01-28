package com.italia.soaproject.soap;

import javax.xml.ws.Endpoint;

import com.italia.soaproject.soap.book.BookController;

public class SoapService {
	
	public static void main(String[] args) {
		Endpoint.publish("https://localhost:8080/LibraryManagement/book", new BookController());
		
	}

}
