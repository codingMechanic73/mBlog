package com.example.Dao;

import com.example.beans.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> getAllUser() throws SQLException, ClassNotFoundException;

    int createUser(User user) throws SQLException, ClassNotFoundException;
}
