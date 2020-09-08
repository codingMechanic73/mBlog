package com.example.Dao;

import com.example.beans.User;

import java.sql.SQLException;

public interface UserDao {

    User createUser(User user) throws SQLException, ClassNotFoundException;

    User getUserByEmail(String email) throws SQLException, ClassNotFoundException;
}
