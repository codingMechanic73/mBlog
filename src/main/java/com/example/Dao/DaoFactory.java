package com.example.Dao;

public interface DaoFactory {

    UserDao getUserDao();

    PostDao getPostDao();
}
