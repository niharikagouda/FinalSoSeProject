package com.italia.soaproject.rest.user.database;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.bson.Document;

import com.italia.soaproject.mongodb.JavaMongoConnection;
import com.italia.soaproject.rest.user.model.Login;
import com.italia.soaproject.rest.user.model.User;
import com.mongodb.BasicDBObject;

public class UserDatabaseImpl implements UserDatabase {
	
	JavaMongoConnection conn = new JavaMongoConnection();
	
	public void addUser(User user) {
		
		Document doc = new Document();
		doc.put("studentId", user.getUserId());
		doc.put("name", user.getUserName());
		conn.insert("student", doc);
	}
	
	public   List<User> listUsers(){
		List<Document> docs = conn.findDocument("student", new BasicDBObject());
		
		
		
		return null;
		
		
	}
	
	public Login isValidUser(Login  login) {
		BasicDBObject match = new  BasicDBObject();
		//input which we are giving - getLoginId
		//matching take place between db and input
		match.append("loginId", login.getLoginId());
		match.append("password", login.getPassword());
		
		//matching documents are stored are in  loginDocs
		List<Document> loginDocs = conn.findDocument("login", match);
		//after matching//
		
		//if something matched
		if(loginDocs.size() == 1) {
			//taking one one record at a time.
			Document doc = loginDocs.get(0);
			//getting isAdmin value from db ,it is false or true,if true=valid admin otherwise not ,the result will pass to login object.
			login.setAdmin(doc.getBoolean("isAdmin"));
			//geeting username from that document and the result will pass to login. 
			login.setUsername(doc.getString("username"));
			//pass true/false or niharika /gagana (ready with output then it will pass to useradmincontroller() )
			return login;
		}
		
		return null;
	}
	

	
	
}
