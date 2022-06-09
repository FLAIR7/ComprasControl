package model.service;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProductDAO;
import model.entities.Product;
import model.entities.User;

public class ProductService {
	
	private ProductDAO dao;
	private User user;
	
	public ProductService(User user) {
		this.dao = DaoFactory.createProductDao(user);
		this.user = user;
	}
	
	public List<Product> findAll(){
		return dao.findAll();
	}
	
	
}
