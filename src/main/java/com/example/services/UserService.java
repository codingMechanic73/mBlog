package com.example.services;

import com.example.beans.User;

public interface UserService {
    User createUser(User user);

    User getUser(User user);
}
