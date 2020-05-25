package com.jade.listener;

import javax.servlet.http.*;
import java.io.Serializable;

public class MyBean implements HttpSessionBindingListener, HttpSessionActivationListener, Serializable {
    private static final long serialVersionUID = 8376610207251903658L;

    /**
     * 该方法被调用时，打印出对象被绑定的信息
     *
     * @param httpSessionBindingEvent
     */
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {

        HttpSession session = httpSessionBindingEvent.getSession();
        String name = httpSessionBindingEvent.getName();

        System.out.println("当前session ID 表示为：" + session.getId() + ", session 值： " + httpSessionBindingEvent.getValue());
        System.out.println("对象被绑定到这session对象中的" + name + "属性上");

    }

    /**
     * 该方法被调用时，打印出对象被解除绑定的信息
     *
     * @param httpSessionBindingEvent
     */
    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        String name = httpSessionBindingEvent.getName();

        System.out.println("当前session ID 表示为：" + session);
        System.out.println("对象从session对象中的" + name + "属性上解除绑定");


    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {

        System.out.println("对象被持久化到文件系统中");

    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("对象从文件系统中恢复了");
    }
}
