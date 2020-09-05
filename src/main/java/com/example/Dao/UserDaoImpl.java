package com.example.Dao;

import com.example.beans.User;

public class UserDaoImpl implements UserDao {

    @Override
    public User createUser(User user) {
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        return new User(email, "**");
    }
}
