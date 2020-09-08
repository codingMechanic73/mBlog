package com.example.Dao;

import com.example.beans.User;
import com.example.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {

    static UserDao userDao;

    private UserDaoImpl() {
    }

    public static UserDao getInstance() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    @Override
    public User createUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        boolean res = statement.execute("Insert into public.\"User\" values (1, \"alan\", \"winsotn\") ");
        if (res) {
            return user;
        }
        return new User();
    }

    @Override
    public User getUserByEmail(String email) throws SQLException, ClassNotFoundException {
//        Connection connection = DatabaseConnection.getConnection();
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery("SELECT user, password FROM public.\"User\" where email=\"" + email + "\";");
//        while (rs.next()) {
//            User user = new User(rs.getString("user"), rs.getString("password"));
//        }
//        return new User();
        User user = new User();
        user.setEmail(email);
        user.setPassword("1234");
        return user;
    }
}
