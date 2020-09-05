package com.example.Dao;

public class DaoFactoryImpl implements DaoFactory{

    private static UserDao userDao;

    @Override
    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }
}
