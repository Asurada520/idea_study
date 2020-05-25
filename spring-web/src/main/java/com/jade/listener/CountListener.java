package com.jade.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// HttpSessionListener implementation
public class CountListener implements HttpSessionListener{

    // 用于统计在线人数的变量
    private int count = 0;

    /**
     * @param httpSessionEvent  session 事件对象
     */
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        count++; // session is created, count ++
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        servletContext.setAttribute("count",new Integer(count));

    }

    /**
     * @param httpSessionEvent  session 事件对象
     */
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        count--; // session is destroyed, count --
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        servletContext.setAttribute("count",new Integer(count));
    }


}
