package com.example.services;

import com.example.beans.User;
import com.example.exceptions.EmailExists;
import com.example.exceptions.InvalidCredentials;
import com.example.exceptions.UserDoesntExist;
import com.example.exceptions.UserNameExists;

public interface UserService {
    boolean createUser(User user) throws EmailExists, UserNameExists;

    User getUser(User user) throws UserDoesntExist, InvalidCredentials;
}
