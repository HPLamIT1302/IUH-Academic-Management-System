package model;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private boolean role;
	
	public User(String username, String password, boolean role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	/*
	 * role là vai trò của user
	 * nếu role là true thì có nghĩa là vai trò admin
	 * nếu role là false thì là người dùng.
	 */
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	
	
}
