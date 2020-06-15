package com.italia.soaproject.returnBook;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;

import org.apache.cxf.jaxws.ServerAsyncResponse;
import org.bson.Document;

import com.italia.soaproject.mongodb.JavaMongoConnection;
import com.mongodb.BasicDBObject;

public class BookReturnControllerImpl implements BookReturnController {

	JavaMongoConnection connection = new JavaMongoConnection();
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public boolean returnBook(String isbn, Integer userId) {
		
		  BasicDBObject match = new BasicDBObject();
		  
		  match.append("bookId", isbn);
		  match.append("userId", userId);
		  match.append("return_date",null);
		  
		  BasicDBObject update = new BasicDBObject(); 
		  update.append("$set", new BasicDBObject().append("return_date", new Date()));
		  
		  System.out.println(update.toString());
		  
		  Document doc=connection.updateDocument("issued_book", update, match);
		  if (doc==null)
			  return false;
		  
		  return true;
		
	}
	
	

	public Future<?> findBookWithReturnAsync(final String isbn, final AsyncHandler<FindBook> asyncHandler) {
		System.out.println(formatter.format(new Date())
				+ " - executing sendMessageWithReturnAsync with AsyncHandler asynchronously");
		final ServerAsyncResponse<FindBook> asyncResponse = new ServerAsyncResponse<FindBook>();
		new Thread() {
			@SuppressWarnings("restriction")
			public void run() {
				try {
					Thread.sleep(10000); // 10s
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// DB call to get the book

				List<Document> docs = connection.findDocument("book", new BasicDBObject("ISBN", isbn));

				FindBook response = new FindBook();
				response.setName(docs.get(0).getString("name"));

				asyncResponse.set(response);
				System.out.println(formatter.format(new Date()) + " - responding on background thread");
				asyncHandler.handleResponse(asyncResponse);
			}
		}.start();
		return asyncResponse;
	}

}