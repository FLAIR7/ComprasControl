package model.dao;

import java.util.List;

import model.entities.Product;

public interface ProductDAO {
	
	Product findById(Long id);
	
	List<Product> findAll();
	
	List<Product> findByName();
	
	void save(Product product);
	
	void update(Product product);
	
	void deleteById(Product product);
	
	boolean isUserProduct(Long id);
	
}
