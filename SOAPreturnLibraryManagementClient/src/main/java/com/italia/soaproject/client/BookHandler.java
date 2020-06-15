package com.italia.soaproject.client;

import com.italia.soaproject.returnBook.FindBook;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

public class BookHandler implements AsyncHandler<FindBook> {

	private FindBook findBook;

	//@Override
	public void handleResponse(Response<FindBook> response) {
		try {
			findBook = response.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public FindBook getResponse() {
		return findBook;
	}
}
