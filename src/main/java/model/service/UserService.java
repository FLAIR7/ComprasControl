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
	
	public void update(User u) {
		User user = dao.findById(u.getUserId());
		if(user != null) {
			if(!UserValidation.usernameExistLogin(u.getName())) {
				user.setName(u.getName());
				user.setPassword(u.getPassword());
				user.setUsername(u.getName());
			}
		}
	}
	
	public boolean update(Long userId, String name, String username) {
		User user = dao.findById(userId);
		if(user != null) {
			UserValidation.usernameValidation(user, username);
			user.setName(name);
			dao.update(user);
			return true;
		}
		return false;
	}
	
	public User findById(Long userId) {
		return dao.findById(userId);
	}
	
	public User changePassword(User user, String newPassword, String password) {
		user.setPassword(password);
		dao.update(user);
		return user;
	}
	
}
