package com.example.services;


import com.example.exceptions.SomethingWentWrong;

import java.sql.SQLException;

public interface ServiceFactory {

    UserService getUserService() throws SomethingWentWrong;

    PostService getPostService() throws SomethingWentWrong;

}
