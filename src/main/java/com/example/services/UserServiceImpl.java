package com.example.services;

import com.example.Dao.DaoFactoryImpl;
import com.example.Dao.UserDao;
import com.example.beans.User;
import com.example.exceptions.EmailExists;
import com.example.exceptions.InvalidCredentials;
import com.example.exceptions.UserDoesntExist;
import com.example.exceptions.UserNameExists;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserDao userDao;
    private static UserService userService;
    private static List<User> users;

    private UserServiceImpl() throws SQLException, ClassNotFoundException {
        users = userDao.getAllUser();
    }


    public static UserService getInstance() {
        if (userDao == null) {
            userDao = DaoFactoryImpl.getInstance().getUserDao();

            try {
                userService = new UserServiceImpl();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return userService;
    }

    @Override
    public boolean createUser(User user) throws EmailExists, UserNameExists {
        try {
            List<User> users = userDao.getAllUser();
            for (User u : users) {
                if (u.getUserName().equals(user.getUserName())) {
                    throw new EmailExists("Email already exists!");
                } else if (u.getEmail().equals(user.getEmail())) {
                    throw new UserNameExists("Email already exists!");
                }
            }
            users.add(user);
            System.out.println("User created");
            new Thread(() ->  {
                try {
                    userDao.createUser(user);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }).start();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUser(User user) throws UserDoesntExist, InvalidCredentials {
        try {
            List<User> users = userDao.getAllUser();
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

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
