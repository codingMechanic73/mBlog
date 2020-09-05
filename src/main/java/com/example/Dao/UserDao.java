package com.example.Dao;

import com.example.beans.User;

public interface UserDao {

    User createUser(User user);

    User getUserByEmail(String email);
}
