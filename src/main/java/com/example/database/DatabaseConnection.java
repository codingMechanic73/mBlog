package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton class which givens connection object
 */
public class DatabaseConnection {
    private static Connection con;
    private static DatabaseConnection db;
    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        if (db == null) {
            db = new DatabaseConnection();
        }
        return db;
    }
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        if (con == null) {

            // heroku provides an easier way to access driver, url, user, password
            // from the environment variables
//            Class.forName(System.getenv("driver"));
//            Connection con = DriverManager.getConnection(
//                    System.getenv("url"),
//                    System.getenv("user"),
//                    System.getenv("password"));
//            System.out.println(con);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mblog", "root", "H@cks@lt1");
            System.out.println(con);
            return con;

        }
        return con;
    }


}
