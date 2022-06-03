package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    private static Connection conn = null;

    public static Connection getConnection(){

        if (conn == null) {
            try {
            	String url = "jdbc:mysql://localhost:3306/test";
            	String user = "root";
            	String password = "";
            	Class.forName("com.mysql.cj.jdbc.Driver");                
            	conn = DriverManager.getConnection(url, user, password);

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            } catch(ClassNotFoundException e) {
            	throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}