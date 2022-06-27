package model.dao;

import model.entities.User;

import java.util.List;

public interface UserDAO {
	
	User login(String username, String password);
	
	boolean signUp(User user);
		
	void update(User user);
	
	User findById(Long userId);
	
    List<String> findAllUsernames();
 }
