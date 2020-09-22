package com.example.services;

import java.sql.SQLException;

public class ServiceFactoryImpl implements ServiceFactory {
    private static UserService userService;
    private static ServiceFactory serviceFactory;
    private static PostService postService;

    private ServiceFactoryImpl() {
    }

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public UserService getUserService() throws SomethingWentWrong {
        if (userService == null) {
            userService = UserServiceImpl.getInstance();
        }
        return userService;
    }

    @Override
    public PostService getPostService() throws SQLException, ClassNotFoundException {
        if (postService == null) {
            postService = PostServiceImpl.getInstance();
        }
        return postService;
    }


}
