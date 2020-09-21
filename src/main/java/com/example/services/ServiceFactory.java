package com.example.services;


import java.sql.SQLException;

public interface ServiceFactory {

    UserService getUserService();

    PostService getPostService() throws SQLException, ClassNotFoundException;

}
