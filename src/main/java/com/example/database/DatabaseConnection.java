package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton class which givens connection object
 */
public class DatabaseConnection {
    private static Connection con;

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        if (con == null) {

            // heroku provides an easier way to access driver, url, user, password
            // from the environment variables
            Class.forName(System.getenv("driver"));
            Connection con = DriverManager.getConnection(
                    System.getenv("url"),
                    System.getenv("user"),
                    System.getenv("password"));
            System.out.println(con);

        }
        return con;
    }
}
