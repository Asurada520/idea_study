package com.jade.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyAttributeListener implements ServletRequestAttributeListener, HttpSessionAttributeListener, ServletContextAttributeListener {


    /**
     * servletContext 新增属性
     *
     * @param servletContextAttributeEvent servletContextAttribute 属性监听对象
     */
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        String attributeName = servletContextAttributeEvent.getName();
        Object attributeValue = servletContextAttributeEvent.getValue();
        System.out.println("ServletContext 对象新增属性：" + attributeName + "，值为：" + attributeValue);
    }

    /**
     * servletContext 移除属性
     *
     * @param servletContextAttributeEvent servletContextAttribute 属性监听对象
     */
    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        String attributeName = servletContextAttributeEvent.getName();
        System.out.println("ServletContext 对象中移除属性：" + attributeName);
    }

    /**
     * servletContext 替换属性
     *
     * @param servletContextAttributeEvent servletContextAttribute 属性监听对象
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        String attributeName = servletContextAttributeEvent.getName();
        Object attributeValue = servletContextAttributeEvent.getValue();
        Object replacedAttribute = servletContextAttributeEvent.getServletContext().getAttribute(attributeName);

        System.out.println("ServletContext 对象中替换属性：" + attributeName + ",原值：" + attributeValue + ", 替换为：" + replacedAttribute);
    }


    /**
     * httpSession 绑定属性
     *
     * @param httpSessionBindingEvent session 属性监听对象
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        String bindingName = httpSessionBindingEvent.getName();
        Object bindingValue = httpSessionBindingEvent.getValue();
        System.out.println("HttpSession 对象 绑定属性：" + bindingName + ", 值：" + bindingValue);

    }

    /**
     * httpSession 移除属性
     *
     * @param httpSessionBindingEvent session 属性监听对象
     */
    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        String bindingName = httpSessionBindingEvent.getName();
        System.out.println("HttpSession 对象 解绑属性：" + bindingName);
    }

    /**
     * httpSession 替换属性
     *
     * @param httpSessionBindingEvent session 属性监听对象
     */
    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        String bindingName = httpSessionBindingEvent.getName();
        Object bindingValue = httpSessionBindingEvent.getValue();
        Object replacedAttribute = httpSessionBindingEvent.getSession().getAttribute(bindingName);
        System.out.println("HttpSession 对象 替换绑定属性：" + bindingName + ",原值：" + bindingValue + ", 替换为：" + replacedAttribute);
    }


    /**
     * ServletRequestAttribute 新增属性
     *
     * @param servletRequestAttributeEvent request请求对象
     */
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {

        String name = servletRequestAttributeEvent.getName();
        Object value = servletRequestAttributeEvent.getValue();

        System.out.println("Request 对象 新增属性：" + name + ", 值：" + value);
    }

    /**
     * ServletRequestAttribute 移除属性
     *
     * @param servletRequestAttributeEvent request请求对象
     */
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String name = servletRequestAttributeEvent.getName();
        System.out.println("Request 对象 删除属性：" + name);
    }

    /**
     * ServletRequestAttribute 替换属性
     *
     * @param servletRequestAttributeEvent request请求对象
     */
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String name = servletRequestAttributeEvent.getName();
        Object value = servletRequestAttributeEvent.getValue();
        Object newValue = servletRequestAttributeEvent.getServletRequest().getAttribute(name);
        System.out.println("Request 对象 替换属性：" + name + ", 原值：" + value+", 新值：" + newValue);
    }

}
