package com.ybzbcq.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
//@Aspect  // 制定一个类为切面类
public class AopLog {

    // 制定切入点表达式
//    @Pointcut("execution(* com.ybzbcq.proxy.UserServiceImpl.insert(..))")
//    public void pointCut(){}


    @Before("execution(* com.ybzbcq.proxy.UserServiceImpl.insert(..))")
    public void begin(){
        System.out.println("测试前置通知");
    }

    @After("execution(* com.ybzbcq.proxy.UserServiceImpl.insert(..))")
    public void after(){
        System.out.println("测试后置通知");
    }


    @AfterReturning("execution(* com.ybzbcq.proxy.UserServiceImpl.insert(..))")
    public void afterReturning(){
        System.out.println("测试运行通知");
    }

    @AfterThrowing("execution(* com.ybzbcq.proxy.UserServiceImpl.insert(..))")
    public void afterThrowing(){
        System.out.println("测试异常通知");
    }

    @Around("execution(* com.ybzbcq.proxy.UserServiceImpl.insert(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("测试环绕通知 开始");
        proceedingJoinPoint.proceed();
        System.out.println("测试环绕通知 结束");

    }
}
