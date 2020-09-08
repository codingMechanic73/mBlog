package com.example.services;

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
    public UserService getUserService() {
        if (userService == null) {
            userService = UserServiceImpl.getInstance();
        }
        return userService;
    }

    @Override
    public PostService getPostService() {
        if (postService == null) {
            postService = PostServiceImpl.getInstance();
        }
        return postService;
    }


}
