package com.italia.soaproject.returnBook;

import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;

@WebService
public interface BookReturnController {

	@WebMethod
	public boolean returnBook(String isbn, Integer userId);
	/* comment commit */

	@WebMethod
	@ResponseWrapper(localName = "findBookWithReturnAsync", className = "com.italia.soaproject.returnBook.FindBook")
	public Future<?> findBookWithReturnAsync(String isbn, AsyncHandler<FindBook> asyncHandler);

}
