package com.ybzbcq.aop;

import com.ybzbcq.annotation.ExtTransaction;
import com.ybzbcq.utils.TransactionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
public class AopExtTransaction {

    @Autowired
    private TransactionUtils transactionUtils;

    @AfterThrowing("execution(* com.ybzbcq.service.*.*(..))")
    public void afterThrowing(){
        System.out.println("Exception, transaction rollback ...");
        transactionUtils.rollback();
    }

    @Around("execution(* com.ybzbcq.service.*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 获取代理对象的方法
        ExtTransaction extTransaction = getExtTransaction(proceedingJoinPoint);
        begin(extTransaction);
        // 调用目标代理对象方法
        proceedingJoinPoint.proceed();
        commit(extTransaction);

    }

    private void commit(ExtTransaction extTransaction) {
        if(extTransaction != null){
            // 如果存在事务，就提交事务
            System.out.println("Transaction commit ... ");
            transactionUtils.commit();
        }
    }

    private void begin(ExtTransaction extTransaction) {
        if(extTransaction != null){
            // 如果存在事务，就开始事务
            System.out.println("Transaction begin ... ");
            transactionUtils.begin();
        }else{
            System.out.println("您的方法上没有添加该注解");
        }
    }

    private ExtTransaction getExtTransaction(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException {
        // 获取方法名称
        String methodName = proceedingJoinPoint.getSignature().getName();
        // 获取目标对象
        Class<?> classTarget = proceedingJoinPoint.getTarget().getClass();
        System.out.println("classTarget:" + classTarget);
        // 获取目标对象类型
        Class[] parameterTypes = ((MethodSignature) proceedingJoinPoint.getSignature()).getParameterTypes();
        System.out.println("parameterTypes:"+Arrays.toString(parameterTypes));
        // 获取目标对象方法
        Method method = classTarget.getMethod(methodName, parameterTypes);

        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println("args: "+Arrays.toString(args));

        // 获取该方法上是否 有事务注解
        return method.getDeclaredAnnotation(ExtTransaction.class);
    }
}
