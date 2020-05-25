package com.ybzbcq.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxyTest {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        ClassLoader classLoader = userService.getClass().getClassLoader();
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandlerImpl(userService);

        // 主要类加载器 一组接口 调用处理 动态代理实例
        UserService proxy = (UserService)Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        proxy.insert();

    }
}
