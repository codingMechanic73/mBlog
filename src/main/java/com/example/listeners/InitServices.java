package com.example.listeners;

import com.example.exceptions.SomethingWentWrong;
import com.example.services.ServiceFactory;
import com.example.services.ServiceFactoryImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class InitServices implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ServiceFactory factory = ServiceFactoryImpl.getInstance();
            factory.getPostService();
            factory.getUserService();
            System.out.println("Services Initialized");
        } catch (SomethingWentWrong s) {
            System.out.println(s.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
