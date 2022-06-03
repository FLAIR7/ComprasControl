package model.validation;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.dao.DaoFactory;
import model.dao.UserDAO;
import model.exceptions.LoginException;

public class UserValidation{
	
	private static String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";    
	
	public static boolean usernameExist(String newUsername) {
		UserDAO dao = DaoFactory.createUserDao();
		List<String> usernames = dao.findAllUsernames();
		boolean exist = usernames.stream().anyMatch(x -> x.equals(newUsername));
		if(exist) {
			throw new LoginException("User already exist");
		}
		return false;
	}
			
	public static boolean isPasswordValid(String pass1, String pass2) {
		return pass1.equals(pass2);
	}
	
	public static boolean isFieldValid(String field) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(field);
		return matcher.matches();
	}
	
}
