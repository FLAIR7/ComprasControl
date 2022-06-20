package model.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
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
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = this.conn.prepareStatement("SELECT * FROM product WHERE product_id=?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Product p = new Product(rs.getLong("product_id"), rs.getString("name"), rs.getDouble("price"),
						rs.getBoolean("comprado"));
				return p;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		return null;
	}

	@Override
	public List<Product> findAll() {
		List<Product> products = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = this.conn.prepareStatement("SELECT * FROM product WHERE user=?");
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
	public List<Product> findByName(String name) {
		List<Product> products = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = this.conn.prepareStatement("SELECT * FROM product WHERE name LIKE" + "'%" + name + "%'");
			rs = st.executeQuery();
			while(rs.next()) {
				products.add(new Product(rs.getLong("product_id"), rs.getString("name"), rs.getDouble("price"),
						rs.getBoolean("comprado")));
			}
			return products;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
		}
		return null;
	}

	@Override
	public void save(Product product) {
		PreparedStatement st = null;
		int row = 0;
		try {
			st = this.conn.prepareStatement("INSERT INTO product (name, price, comprado, user) VALUES (?, ?, ?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, product.getName());
			st.setDouble(2, product.getPrice());
			st.setBoolean(3, product.isComprado());
			st.setLong(4, user.getUserId());
			row = st.executeUpdate();
			if(row > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					product.setProductId(rs.getLong(1));
				}
				DB.closeResultSet(rs);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Product product) {
		PreparedStatement st = null;
		try {
			st = this.conn.prepareStatement("UPDATE product SET name=?, price=?, comprado=? WHERE product_id=?");
			st.setString(1, product.getName());
			st.setDouble(2, product.getPrice());
			st.setBoolean(3, product.isComprado());
			st.setLong(4, product.getProductId());
			st.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Product product) {
		PreparedStatement st = null;
		try {
			st = this.conn.prepareStatement("DELETE FROM product WHERE product_id=?");
			st.setLong(1, product.getProductId());
			int row = st.executeUpdate();
			if(row == 0) {
				throw new DbException("Erro, não executou excluir");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public boolean isProductValid(Long id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = this.conn.prepareStatement("SELECT * FROM product WHERE user=?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
