package com.example.services;

import com.example.beans.User;
import com.example.exceptions.*;


public interface UserService {
    boolean createUser(User user) throws EmailExists, UserNameExists, SomethingWentWrong;

    User getUser(User user) throws UserDoesntExist, InvalidCredentials;
}
