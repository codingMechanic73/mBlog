package com.example.Dao;

import java.sql.SQLException;

public class DaoFactoryImpl implements DaoFactory {

    private static UserDao userDao;
    private static PostDao postDao;

    private static DaoFactory daoFactory;

    private DaoFactoryImpl() {
    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactoryImpl();
        }
        return daoFactory;
    }

    @Override
    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = UserDaoImpl.getInstance();
        }
        return userDao;
    }

    @Override
    public PostDao getPostDao() {
        if (postDao == null) {
            postDao = PostDaoImpl.getInstance();
        }
        return postDao;
    }


}
