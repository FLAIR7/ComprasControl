package model.dao;

import db.DB;
import model.dao.imp.ProductJDBC;
import model.dao.imp.UserJDBC;
import model.entities.User;

public class DaoFactory {
	
	public static UserDAO createUserDao() {
		return new UserJDBC(DB.getConnection());
	}
	
	public static ProductDAO createProductDao(User user) {
		return new ProductJDBC(DB.getConnection(), user);
	}
}
