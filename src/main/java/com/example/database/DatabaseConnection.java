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
            con = getOnlineConnection();
        }
        return con;
    }

    public Connection getLocalConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/databaseName", "userName", "password");
    }

    public Connection getOnlineConnection() throws ClassNotFoundException, SQLException {
        Class.forName(System.getenv("driver"));
        return DriverManager.getConnection(
                System.getenv("url"),
                System.getenv("user"),
                System.getenv("password"));
    }


}
