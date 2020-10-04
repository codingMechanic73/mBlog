package com.example.services;

import com.example.Dao.DaoFactoryImpl;
import com.example.Dao.UserDao;
import com.example.beans.User;
import com.example.exceptions.*;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserDao userDao;
    private static UserService userService;
    private static List<User> users;

    private UserServiceImpl() {

    }


    public static UserService getInstance() throws SomethingWentWrong {
        if (userService == null) {
            userDao = DaoFactoryImpl.getInstance().getUserDao();
            try {
                users = userDao.getAllUser();
                userService = new UserServiceImpl();
            } catch (SQLException | ClassNotFoundException e) {
                throw new SomethingWentWrong("Something went wrong!");
            }
        }
        return userService;
    }

    @Override
    public boolean createUser(User user) throws EmailExists, UserNameExists, SomethingWentWrong {
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                throw new UserNameExists("UserName taken!");

            } else if (u.getEmail().equals(user.getEmail())) {
                throw new EmailExists("Email already exists!");

            }
        }
        try {
            userDao.createUser(user);
            users.add(user);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new SomethingWentWrong("Something went wrong!");
        }
    }

    @Override
    public User getUser(User user) throws UserDoesntExist, InvalidCredentials {
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                if (u.getPassword().equals(user.getPassword())) {
                    return u;
                } else {
                    throw new InvalidCredentials("Wrong password!");
                }
            }
        }
        throw new UserDoesntExist("User Doesn't Exist!");
    }
}
