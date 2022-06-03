package model.dao;

import db.DB;
import model.dao.imp.UserJDBC;

public class DaoFactory {
	
	public static UserDAO createUserDao() {
		return new UserJDBC(DB.getConnection());
	}
}
