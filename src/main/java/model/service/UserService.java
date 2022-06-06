package model.service;

import model.dao.DaoFactory;
import model.dao.UserDAO;
import model.entities.User;
import model.validation.UserValidation;

public class UserService {
	
	private UserDAO dao;
	
	public UserService() {
		this.dao = DaoFactory.createUserDao();
	}
	
	public boolean signUp(User user) {
		UserValidation.usernameExistRegister(user.getName());
		dao.signUp(user);
		return true;
	}
	
	public User login(String username, String password) {
		if(UserValidation.usernameExistLogin(username)) {
			return dao.login(username, password);
		}
		return null;
	}
	
}
