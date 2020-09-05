package com.example.services;

public class ServiceFactoryImpl implements ServiceFactory {
    private static UserService userService;

    @Override
    public UserService getUserService() {
        if (userService == null) {
            userService = UserServiceImpl.getInstance();
        }
        return userService;
    }

}
