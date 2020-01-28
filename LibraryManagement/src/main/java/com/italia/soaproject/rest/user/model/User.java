package com.italia.soaproject.rest.user.model;

public class User {
	
	public String userId;
	public String userName;
	boolean isAdmin;
	
	public User(String userId, String userName, boolean isAdmin) {
		this.userId = userId;
		this.userName = userName;
		this.isAdmin = isAdmin;
	}
	
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


}

