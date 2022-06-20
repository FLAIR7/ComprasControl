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
	
	public Product findById(Long id) {
		return dao.findById(id);
	}

	public void deleteById(Long id) {
		Product product = dao.findById(id);
		if(product != null) {
			dao.deleteById(product);
		}
	}
	
	public void save(Product p) {
		dao.save(p);
	}

	public void update(Product p) {
		dao.update(p);
	}
	
	
}
