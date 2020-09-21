package com.example.Dao;

import com.example.beans.User;
import com.example.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static UserDao userDao;

    private static List<User> users;

    private UserDaoImpl() {

    }

    public static UserDao getInstance() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    @Override
    public List<User> getAllUser() throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select userName, email, password from user");
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User(resultSet.getString("userName"), resultSet.getString("email"), resultSet.getString("password"));
            users.add(user);
        }
        return users;
    }

    @Override
    public int createUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mblog.user(email, password, userName) values(?, ?, ?)");
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getUserName());
        return preparedStatement.executeUpdate();
    }

}
