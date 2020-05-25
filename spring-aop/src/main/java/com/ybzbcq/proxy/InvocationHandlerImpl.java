package com.ybzbcq.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


// 每次生成动态代理对象时，实现 InvocationHandler接口的调用处理对象

public class InvocationHandlerImpl implements InvocationHandler {

    private Object target; // 业务类实现类对象，用来调用具体的业务方法

    /**
     * 构造方法 传入目标对象
     * @param target
     */
    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理 调用开始");
        Object result = method.invoke(target, args);
        System.out.println("JDK动态代理 调用结束");
        return result;
    }


}
