package model.dao;

import java.util.List;

import model.entities.Product;

public interface ProductDAO {
	
	Product findById(Long id);
	
	List<Product> findAll();
	
	List<Product> findByName(String name);
	
	void save(Product product);
	
	void update(Product product);
	
	void deleteById(Product product);
	
	boolean isProductValid(Long id);
	
}
