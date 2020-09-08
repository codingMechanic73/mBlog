package com.example.services;


public interface ServiceFactory {

    UserService getUserService();

    PostService getPostService();

}
