package it.univaq.odws.maven.sum;

import com.mongodb.BasicDBObject;

import it.univaq.odws.maven.mongodb.JavaMongoConnection;

public class BookControllerImpl implements BookController {
	
	JavaMongoConnection connection = new JavaMongoConnection();
	
	@Override
	public boolean removeBook(String isbn) {
		
		BasicDBObject basicDbObject = new BasicDBObject();

		basicDbObject.append("ISBN", isbn);
		
		connection.deleteDocument("book", basicDbObject);
		return true;
	}

	
}
