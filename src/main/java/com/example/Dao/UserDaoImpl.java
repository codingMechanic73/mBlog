package com.example.Dao;

import com.example.beans.User;
import com.example.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {

    @Override
    public User createUser(User user) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            boolean res = statement.execute("Insert into public.\"User\" values (1, \"alan\", \"winsotn\") ");
            if (res) {
                return user;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }

    @Override
    public User getUserByEmail(String email) {
        return new User(email, "**");
    }
}
