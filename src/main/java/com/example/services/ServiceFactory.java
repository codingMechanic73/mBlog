package com.example.services;


import com.example.exceptions.SomethingWentWrong;


public interface ServiceFactory {

    UserService getUserService() throws SomethingWentWrong;

    PostService getPostService() throws SomethingWentWrong;

}
