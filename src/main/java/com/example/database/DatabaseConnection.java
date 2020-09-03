package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection con;

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        if (con == null) {

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
