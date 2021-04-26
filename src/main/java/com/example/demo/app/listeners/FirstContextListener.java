package com.example.demo.app.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class FirstContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("Servlet context is started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Servlet context is destroyed");
    }
}
