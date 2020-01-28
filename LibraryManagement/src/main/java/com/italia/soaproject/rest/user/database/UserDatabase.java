package com.italia.soaproject.rest.user.database;

import java.util.List;

import com.italia.soaproject.rest.user.model.Login;
import com.italia.soaproject.rest.user.model.User;

public interface UserDatabase {
	
	public void addUser(User user);
	public List<User> listUsers();
	public Login isValidUser(Login login);

}
