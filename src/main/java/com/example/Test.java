package com.example;

import com.example.beans.User;
import com.example.exceptions.EmailExists;
import com.example.exceptions.InvalidCredentials;
import com.example.exceptions.UserDoesntExist;
import com.example.exceptions.UserNameExists;
import com.example.services.PostService;
import com.example.services.ServiceFactory;
import com.example.services.ServiceFactoryImpl;
import com.example.services.UserServiceImpl;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, UserNameExists, EmailExists, UserDoesntExist, InvalidCredentials {
        System.out.println(UserServiceImpl.getInstance().createUser(new User("alan", "b@a.com", "haha")));
//        System.out.println(UserServiceImpl.getInstance().createUser(new User("alan", "a@a.com", "haha")));
        System.out.println(UserServiceImpl.getInstance().getUser(new User("alan", "", "haha")));
    }
}
