package model.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import model.dao.ProductDAO;
import model.entities.Product;
import model.entities.User;

public class ProductJDBC implements ProductDAO{

    private Connection conn;
    private User user;

	public ProductJDBC(Connection conn, User user) {
		this.conn = conn;
		this.user = user;
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		List<Product> products = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = this.conn.prepareStatement("SELECT * FROM product WHERE user = ?");
			st.setLong(1, this.user.getUserId());
			rs = st.executeQuery();
			while(rs.next()) {
				products.add(new Product(rs.getLong("product_id"), rs.getString("name"), rs.getDouble("price"),
						rs.getBoolean("comprado")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		return products;
	}

	@Override
	public List<Product> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUserProduct(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
