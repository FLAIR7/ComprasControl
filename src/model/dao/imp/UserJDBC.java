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
import java.util.List;

public class UserJDBC implements UserDAO {

    private Connection conn;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;

    public UserJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public User login(String username, String password) {
        try{
            st = conn.prepareStatement(
                     " SELECT * FROM" +
                        " user WHERE" +
                        " username = ?" +
                        " AND password = ?"
            );
            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();
            if(rs.next()) {
                return new User(rs.getLong("userId"), rs.getString("name"),
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
    public boolean cadastrar(User user) {
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
    public List<String> findAllUsers() {
        return null;
    }
}
