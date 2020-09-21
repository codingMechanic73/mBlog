package com.example.listeners;

import com.example.services.ServiceFactory;
import com.example.services.ServiceFactoryImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener()
public class InitServices implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ServiceFactory factory = ServiceFactoryImpl.getInstance();
            factory.getPostService();
            factory.getUserService();
            System.out.println("Services Initialized");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
