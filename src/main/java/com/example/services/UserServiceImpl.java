package com.example.services;

import com.example.Dao.DaoFactory;
import com.example.Dao.DaoFactoryImpl;
import com.example.Dao.UserDao;
import com.example.beans.User;

public class UserServiceImpl implements UserService {

    private static UserDao userDao;
    private static UserService userService;


    private UserServiceImpl() {
    }


    public static UserService getInstance() {
        DaoFactory daoFactory = new DaoFactoryImpl();
        if (userDao == null) {
            userDao = daoFactory.getUserDao();
            userService = new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User getUser(User user) {
        return userDao.getUserByEmail(user.getEmail());
    }
}
