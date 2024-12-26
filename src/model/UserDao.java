package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<User> ls = new ArrayList<User>();

	public UserDao(List<User> ls) {
		super();
		this.ls = ls;
	}
	//them tai khoan
	public UserDao() {
		ls.add(new User("admin", "12345", true));
		ls.add(new User("22680401", "2004", true));
		ls.add(new User("A1", "12345", false));
		ls.add(new User("A2", "12345", false));
		ls.add(new User("A3", "12345", false));
	}
	
	public boolean checkLogin(String name, String pass) {
		for (User user : ls) {
			if(user.getUsername().equals(name)
			&& user.getPassword().equals(pass)) {
				return true;
			};
		}
		return false;
	}	
}
