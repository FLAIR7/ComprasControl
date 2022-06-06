package model.dao.imp;
import db.DB;
import db.DbException;
import model.dao.UserDAO;
import model.entities.User;
import model.exceptions.LoginException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserJDBC implements UserDAO {

    private Connection conn;

    public UserJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public User login(String username, String password) {
    	PreparedStatement st = null;
    	ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();
            if(rs.next()) {
                return new User(rs.getLong("user_id"), rs.getString("name"),
                                rs.getString("username"), rs.getString("password"));
            }
            else if(checkIfUsernameExists(username)) {
                throw new LoginException("User does not exists");
            }
        } catch(SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return null;
    }

    @Override
    public boolean signUp(User user) {
    	PreparedStatement st = null;
    	try {
    		st = this.conn.prepareStatement("INSERT INTO user (name, username, password) VALUES (?, ?, ?)");
    		st.setString(1, user.getName());
    	    st.setString(2, user.getUsername());
    	    st.setString(3, user.getPassword());
    		st.executeUpdate();
    		return true;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	} finally{
    		DB.closeStatement(st);
    	}
        return false;
    }

    @Override
    public boolean checkIfUsernameExists(String username) {
        return false;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User findById(Long userId) {
        return null;
    }

    @Override
    public List<String> findAllUsernames() {
    	Statement st = null;
    	ResultSet rs = null;
        List<String> usernames = new ArrayList<>();
        try {
        	st = this.conn.createStatement();
        	rs = st.executeQuery("SELECT username FROM user");
        	while(rs.next()) {
        		usernames.add(rs.getString("username"));
        	}
        	return usernames;
        } catch(SQLException e) {
        	e.printStackTrace();
        }
    	return null;
    }
}