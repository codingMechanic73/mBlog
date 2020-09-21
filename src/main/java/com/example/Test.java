package com.example;

import com.example.services.PostService;
import com.example.services.ServiceFactory;
import com.example.services.ServiceFactoryImpl;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PostService postService = ServiceFactoryImpl.getInstance().getPostService();
        System.out.println(postService.getAllPost());
    }
}
