package it.univaq.odws.maven.mongodb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class JavaMongoConnection {

	/*
	 * DB Configuration
	 */
	public static final String MONGO_DB_URL_STRING = "mongodb://localhost:27017";
	public static final String TEST_DB_NAME = "test";

	public List<Document> findDocument(String collectionName, BasicDBObject match) {

		MongoClientURI connectionString = new MongoClientURI(MONGO_DB_URL_STRING);
		MongoCollection<Document> collection = null;
		List<Document> output = new ArrayList<Document>();

		try {
			MongoClient mongoClient = new MongoClient(connectionString);
			MongoDatabase database = mongoClient.getDatabase(TEST_DB_NAME);
			collection = database.getCollection(collectionName);

			Iterator<Document> finalDocumentIt = collection.find(match).iterator();

			while (finalDocumentIt.hasNext()) {

				Document item = finalDocumentIt.next();

				output.add(item);

			}

			mongoClient.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return output;

	}
	
	
	
/*public List<Document> insertDocument(String collectionName, Document doc) {

		MongoClientURI connectionString = new MongoClientURI(MONGO_DB_URL_STRING);
		MongoCollection<Document> collection = null;
		List<Document> output = new ArrayList<Document>();

		try {
			MongoClient mongoClient = new MongoClient(connectionString);
			MongoDatabase database = mongoClient.getDatabase(TEST_DB_NAME);
			collection = database.getCollection(collectionName);

			Iterator<Document> finalDocumentIt = collection.insertOne(doc);

			while (finalDocumentIt.hasNext()) {

				Document item = finalDocumentIt.next();

				output.add(item);

			}

			mongoClient.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return output;

	}

	
	public List<Document> updateDocument(String collectionName, Document doc, BasicDBObject match) {

		MongoClientURI connectionString = new MongoClientURI(MONGO_DB_URL_STRING);
		MongoCollection<Document> collection = null;
		List<Document> output = new ArrayList<Document>();

		try {
			MongoClient mongoClient = new MongoClient(connectionString);
			MongoDatabase database = mongoClient.getDatabase(TEST_DB_NAME);
			collection = database.getCollection(collectionName);

			Iterator<Document> finalDocumentIt = collection.find(match).iterator();

			while (finalDocumentIt.hasNext()) {

				Document item = finalDocumentIt.next();

				output.add(item);

			}

			mongoClient.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return output;

	}*/


	public boolean insert(String collectionName, Document doc) {
		MongoClientURI connectionString = new MongoClientURI(MONGO_DB_URL_STRING);
		MongoCollection<Document> collection = null;

		try {
			MongoClient mongoClient = new MongoClient(connectionString);
			MongoDatabase database = mongoClient.getDatabase(TEST_DB_NAME);
			collection = database.getCollection(collectionName);

			collection.insertOne(doc);
			
			
			mongoClient.close();
			
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean deleteDocument(String collectionName, BasicDBObject match) {
		MongoClientURI connectionString = new MongoClientURI(MONGO_DB_URL_STRING);
		MongoCollection<Document> collection = null;

		try {
			MongoClient mongoClient = new MongoClient(connectionString);
			MongoDatabase database = mongoClient.getDatabase(TEST_DB_NAME);
			collection = database.getCollection(collectionName);

			collection.deleteOne(match);
			
			
			mongoClient.close();
			
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
	

}
