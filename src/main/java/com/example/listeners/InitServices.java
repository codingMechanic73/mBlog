package com.example.listeners;

import com.example.exceptions.SomethingWentWrong;
import com.example.services.ServiceFactory;
import com.example.services.ServiceFactoryImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class InitServices implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ServiceFactory factory = ServiceFactoryImpl.getInstance();
            Integer count = factory.getPostService().getMaxId();
            factory.getUserService();
            ServletContext sc = sce.getServletContext();
            System.out.println("********LISTENER********");
            System.out.println("Post and User Services Initialized");
            sc.setAttribute("maxId", count);
            System.out.println("Max id fetched:" + count);

        } catch (SomethingWentWrong e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
