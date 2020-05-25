package com.jade.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements ServletContextListener, HttpSessionListener, ServletRequestListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext 对象被创建了 ...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext 对象被销毁了 ...");
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("HttpSession 对象被创建了 ...");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("HttpSession 对象被销毁了 ...");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("ServletRequest 对象被创建了 ...");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("ServletRequest 对象被销毁了 ...");
    }
}
