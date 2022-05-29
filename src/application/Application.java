package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("select * from user");

            while(rs.next()){
                System.out.println(rs.getInt("userId") + ", " + rs.getString("username"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
