package com.example.services;

import com.example.Dao.DaoFactory;
import com.example.Dao.DaoFactoryImpl;
import com.example.Dao.UserDao;
import com.example.beans.User;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private static UserDao userDao;
    private static UserService userService;


    private UserServiceImpl() {
    }


    public static UserService getInstance() {
        if (userDao == null) {
            userDao = DaoFactoryImpl.getInstance().getUserDao();
            userService = new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public User createUser(User user) {
        try {
            return userDao.createUser(user);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUser(User user) {
        try {
            return userDao.getUserByEmail(user.getEmail());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
